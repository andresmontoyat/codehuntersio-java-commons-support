package io.codehunters.commons.security.jwt.util;

import io.codehunters.commons.util.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JWTUtil {

    public static String getToken(String signingKey, String subject, Map<String, Object> claims) {
        return getToken(signingKey, subject, claims, 1000);
    }

    public static String getToken(String signingKey, String subject, Map<String, Object> claims, long expiration) {
        Key key = Keys.hmacShaKeyFor(signingKey.getBytes());
        return Jwts.builder()
                .setId(Util.uuid())
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public static Claims getBody(String signingKey, String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey.getBytes())
                .build()
                .parseClaimsJws(token).getBody();
    }

    public static String getSignature(String signingKey, String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getSignature();
    }
}
