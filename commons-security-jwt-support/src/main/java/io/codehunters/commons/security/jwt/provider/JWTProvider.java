package io.codehunters.commons.security.jwt.provider;

import io.codehunters.commons.properties.JWTProperties;
import io.codehunters.commons.security.jwt.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Base64;
import java.util.Map;

@Slf4j
public class JWTProvider {

    private final String signingKey;

    private final long tokenValidityInMilliseconds;

    private UserDetailsService userDetailsService;

    public JWTProvider(JWTProperties jwtProperties) {
        this.signingKey = Base64.getEncoder().encodeToString(jwtProperties.getSigningKey().getBytes());
        this.tokenValidityInMilliseconds = 1000L * jwtProperties.getToken().getAccessTokenValiditySeconds();
    }

    public String getToken(String subject, Map<String, Object> claims) {
        return JWTUtil.getToken(signingKey, subject, claims, tokenValidityInMilliseconds, SignatureAlgorithm.HS256);
    }

    public String getToken(String subject, Map<String, Object> claims, long expiration) {
        return JWTUtil.getToken(signingKey, subject, claims, expiration, SignatureAlgorithm.HS256);
    }

    public Claims getBody(String token) {
        return JWTUtil.getBody(signingKey, token);
    }

    public Authentication getAuthentication(String token) {
        String username = getBody(token).getSubject();
        UserDetails user = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
    }

    public String getSigningKey() {
        return signingKey;
    }

    public long getTokenValidityInMilliseconds() {
        return tokenValidityInMilliseconds;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
