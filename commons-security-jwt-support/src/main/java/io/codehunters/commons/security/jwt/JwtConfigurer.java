package io.codehunters.commons.security.jwt;

import io.codehunters.commons.security.jwt.filter.JWTAuthenticationFilter;
import io.codehunters.commons.security.jwt.provider.JWTProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JWTProvider jwtProvider;

    public JwtConfigurer(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JWTAuthenticationFilter filter = new JWTAuthenticationFilter(jwtProvider);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
