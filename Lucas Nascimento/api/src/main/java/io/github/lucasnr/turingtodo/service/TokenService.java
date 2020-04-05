package io.github.lucasnr.turingtodo.service;

import io.github.lucasnr.turingtodo.dto.TokenDTO;
import io.github.lucasnr.turingtodo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration.milliseconds}")
    private String expirationMilliseconds;

    @Value("${jwt.secret}")
    private String secret;

    public TokenDTO generate(User user) {
        Date today = new Date();
        Date expiration = new Date(today.getTime() + Long.parseLong(expirationMilliseconds));

        String token = Jwts.builder()
                .setIssuer("TuringTecnologiaTodo")
                .setSubject(user.getEmail())
                .setIssuedAt(today)
                .setExpiration(expiration)
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return new TokenDTO(token);
    }

    public boolean isValidToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Jws<Claims> getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
