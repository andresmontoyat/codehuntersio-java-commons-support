package io.codehunters.commons.security.jwt.util;

import io.codehunters.commons.util.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtil {
    public static final long DEFAULT_EXPIRATION = 0;
    public static final long DEFAULT_BASE_EXPIRATION = 1000;

    public static String generateJwt(String signingKey, String subject, Map<String, Object> claims) {
        return generateJwt(signingKey, subject, SignatureAlgorithm.HS256, claims, DEFAULT_EXPIRATION);
    }

    public static String generateJwt(String signingKey, String subject, Map<String, Object> claims, long expiration) {
        return generateJwt(signingKey, subject, SignatureAlgorithm.HS256, claims, expiration);
    }

    public static String generateJwt(String signingKey, String subject, SignatureAlgorithm signatureAlgorithm, Map<String, Object> claims) {
        return generateJwt(signingKey, subject, signatureAlgorithm, claims, DEFAULT_EXPIRATION);
    }

    public static String generateJwt(String signingKey, String subject, SignatureAlgorithm signatureAlgorithm, Map<String, Object> claims, long expiration) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(signingKey),
                signatureAlgorithm.getJcaName());
        return Jwts.builder()
                .setId(Util.uuid())
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + calculateExpiration(expiration)))
                .signWith(key)
                .compact();
    }

    public static String generateJwt(PrivateKey privateKey, String subject, Map<String, Object> claims) {
        return generateJwt(privateKey, subject, claims, DEFAULT_EXPIRATION);
    }

    public static String generateJwt(PrivateKey privateKey, String subject, Map<String, Object> claims, long expiration) {
        return Jwts.builder()
                .setId(Util.uuid())
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + calculateExpiration(expiration)))
                .signWith(privateKey)
                .compact();
    }

    public static Claims parseJwt(String signingKey, String token) {
        return parseJwt(signingKey, SignatureAlgorithm.HS256, token);
    }

    public static Claims parseJwt(String signingKey, SignatureAlgorithm signatureAlgorithm, String token) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(signingKey),
                signatureAlgorithm.getJcaName());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static Claims parseJwt(PublicKey publicKey, String token) {
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static long calculateExpiration(long expiration) {
        return DEFAULT_BASE_EXPIRATION * expiration;
    }

}
