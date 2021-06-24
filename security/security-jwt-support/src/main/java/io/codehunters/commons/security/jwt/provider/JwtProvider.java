package io.codehunters.commons.security.jwt.provider;

import io.codehunters.commons.properties.JWTProperties;
import io.codehunters.commons.security.jwt.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
public class JwtProvider {

    private final JWTProperties jwtProperties;

    private final UserDetailsService userDetailsService;

    public JwtProvider(JWTProperties jwtProperties, UserDetailsService userDetailsService) {
        this.jwtProperties = jwtProperties;
        this.userDetailsService = userDetailsService;
    }

    public String generateToken(String subject, Map<String, Object> claims) throws KeyStoreException {
        if (Optional.ofNullable(jwtProperties.getKeyStore()).isPresent()) {
            return JwtUtil.generateJwt(getPrivateKey(), subject, claims, calculateExpiration(jwtProperties.getToken().getAccessTokenValiditySeconds()));
        }
        return JwtUtil.generateJwt(jwtProperties.getSigningKey(), subject, claims, calculateExpiration(jwtProperties.getToken().getAccessTokenValiditySeconds()));
    }

    private long calculateExpiration(int accessTokenValidity) {
        return JwtUtil.DEFAULT_EXPIRATION * accessTokenValidity;
    }

    public Claims getBody(String token) throws KeyStoreException {
        if (Optional.ofNullable(jwtProperties.getKeyStore()).isPresent()) {
            return JwtUtil.parseJwt(getPublicKey(), token);
        }
        return JwtUtil.parseJwt(jwtProperties.getSigningKey(), token);
    }

    public Authentication getAuthentication(String token) throws KeyStoreException {
        String username = getBody(token).getSubject();
        UserDetails user = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
    }

    private PrivateKey getPrivateKey() throws KeyStoreException {
        try {
            KeyStore keyStore = keyStore();
            return (PrivateKey) keyStore.getKey(jwtProperties.getPrivateKeyAlias(), jwtProperties.getPrivateKeyPassword().toCharArray());
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    private PublicKey getPublicKey() throws KeyStoreException {
        try {
            KeyStore keyStore = keyStore();
            return keyStore.getCertificate(jwtProperties.getCertificateAlias()).getPublicKey();
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }

    private KeyStore keyStore() throws KeyStoreException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(jwtProperties.getKeyStore().getInputStream(), jwtProperties.getKeyStorePassword().toCharArray());
            return keyStore;
        } catch (Exception e) {
            throw new KeyStoreException(e);
        }
    }
}
