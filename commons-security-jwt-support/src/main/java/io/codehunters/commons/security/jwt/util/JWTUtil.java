package io.codehunters.commons.security.jwt.util;

import io.codehunters.commons.util.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtil {

    public static String getToken(String signingKey, String subject, Map<String, Object> claims, SignatureAlgorithm algorithm) {
        return getToken(signingKey, subject, claims, 1000, algorithm);
    }

    public static String getToken(String signingKey, String subject, Map<String, Object> claims, long expiration, SignatureAlgorithm algorithm) {
        return Jwts.builder()
                .setId(Util.uuid())
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(algorithm,
                        signingKey.getBytes()).compact();
    }

    public static Claims getBody(String signingKey, String token) {
        return Jwts.parser().setSigningKey(signingKey.getBytes()).parseClaimsJws(token).getBody();
    }

    public static String getSignature(String signingKey, String token) {
        return Jwts.parser().setSigningKey(signingKey.getBytes()).parseClaimsJws(token).getSignature();
    }
}
