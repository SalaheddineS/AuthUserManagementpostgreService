package com.service.Authentication.Utilities;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SecretKey;


    private  Key getSigningKey() {
        byte[] keyBytes = SecretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email, int id) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + TimeUnit.HOURS.toMillis(8));

        return Jwts.builder()
                .setSubject(email)
                .setId(String.valueOf(id))
                .setExpiration(expiryDate) // Set expiration time
                .signWith(getSigningKey())
                .compact();
    }

    public  String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public String getIdFromToken(String token) {
       return  Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody().getId();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
