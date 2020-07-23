package io.codehunters.commons.security.web.filter.cors;

import io.codehunters.commons.properties.CORSProperties;
import io.codehunters.commons.security.web.filter.cors.service.CORSService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter extends GenericFilterBean {

    private static final String PERMIT_ACCESS_ALL_ORIGINS = "*";

    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_ALLOW_MAX_AGE = "Access-Control-Max-Age";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS_TRUE = "true";

    private CORSProperties corsProperties;

    private CORSService corsService;

    public CORSFilter(CORSProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origins());
        response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, corsProperties.getMethods());
        response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, corsProperties.getHeaders());
        response.setHeader(ACCESS_CONTROL_ALLOW_MAX_AGE, corsProperties.getMaxAge());

        if (Boolean.TRUE.equals(corsProperties.getAllowCredentials())) {
            response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, ACCESS_CONTROL_ALLOW_CREDENTIALS_TRUE);
        }

        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    private String origins() {

        if (PERMIT_ACCESS_ALL_ORIGINS.equals(corsProperties.getOrigins())) {
            return corsProperties.getOrigins();
        }

        if(corsService != null) {
            List<String> origins = corsService.fetchAll();
            if (origins == null) {
                origins = new ArrayList<>();
            }

            origins.add(corsProperties.getOrigins());
            return origins.stream()
                    .collect(Collectors.joining(","));
        }

        return corsProperties.getOrigins();
    }

}