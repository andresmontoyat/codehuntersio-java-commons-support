package io.codehunters.commons.security.jwt.configurer;

import io.codehunters.commons.security.jwt.filter.JWTAuthenticationFilter;
import io.codehunters.commons.security.jwt.provider.JwtProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtProvider jwtProvider;

    @Override
    public void configure(HttpSecurity http) {
        JWTAuthenticationFilter filter = new JWTAuthenticationFilter(jwtProvider);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
