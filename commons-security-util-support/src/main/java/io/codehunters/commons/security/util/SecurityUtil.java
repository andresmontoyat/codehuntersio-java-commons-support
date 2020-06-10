package io.codehunters.commons.security.util;

import io.codehunters.commons.security.SecurityException;
import io.codehunters.commons.security.jwt.provider.JWTProvider;
import io.codehunters.commons.util.hashids.HashId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class SecurityUtil {

    private PasswordEncoder passwordEncoder;

    private JWTProvider jwtProvider;

    private HashId hashId;

    public String passwordEncode(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean passwordMatches(String password, String hash) {
        return passwordEncoder.matches(password, hash);
    }
    
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }

        throw new SecurityException("An error has occurred trying to get username");
    }

}
