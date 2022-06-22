package com.ll.store.config.security.service;

import com.ll.store.repository.entity.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${store.jwt.expiration}")
    private String expiration;

    @Value("${store.jwt.secret}")
    private String secret;

    public String tokenGenerate(Authentication authentication){
        User logged = (User) authentication.getPrincipal();
        Date date = new Date();
        Date expirationDate = new Date(date.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("LLStore")
                .setSubject(logged.getId().toString())
                .setIssuedAt(date)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256 ,secret)
                .compact();
    }

    public boolean tokenIsValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
