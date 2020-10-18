package io.codehunters.commons.security.jwt.filter;

import io.codehunters.commons.security.jwt.provider.JWTProvider;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class JWTAuthenticationFilter extends GenericFilterBean {

    private Set<String> blackList = new TreeSet<>();

    public final static String AUTHORIZATION_HEADER = "Authorization";

    private JWTProvider jwtProvider;

    public JWTAuthenticationFilter(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        try {
            if ((SecurityContextHolder.getContext().getAuthentication() != null) && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }

            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String jwt = resolveToken(request);

            boolean cookie = true;

            if (jwt == null) {
                jwt = resolveInCookie(request);
            }

            if (jwt == null) {
                jwt = servletRequest.getParameter("t");
            }

            if (jwt != null && blackList.contains(jwt)) {
                jwt = null;
                response.sendError(403);
                return;
            }

            if (jwt != null) {
                try {
                    Authentication authentication = this.jwtProvider.getAuthentication(jwt);
                    if (authentication != null) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                } catch (Exception ex) {
                    if (ex instanceof ExpiredJwtException) {
                        blackList.add(jwt);
                    }

                    if (cookie) {
                        deleteCookies(request, response);
                    }

                    response.sendError(403);
                    return;
                }
            }
            chain.doFilter(servletRequest, servletResponse);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
                | UsernameNotFoundException e) {
            log.error("Security exception", e);
            ((HttpServletResponse) servletResponse)
                    .setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private void deleteCookies(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie1 : cookies) {
                cookie1.setValue("");
                cookie1.setPath("/");
                cookie1.setMaxAge(0);
                httpServletResponse.addCookie(cookie1);
            }
        }
    }

    private String resolveInCookie(HttpServletRequest httpServletRequest) {
        for (Cookie cookie : Optional.ofNullable(httpServletRequest.getCookies()).orElse(new Cookie[0])) {
            if (cookie.getName().equals("JSESSION")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
