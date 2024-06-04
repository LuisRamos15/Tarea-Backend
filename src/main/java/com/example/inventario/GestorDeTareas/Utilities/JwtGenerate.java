package com.example.inventario.GestorDeTareas.Utilities;

import com.example.inventario.GestorDeTareas.Models.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtGenerate {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPITATION_TIME = 900_000;
    private static final String ISSUER  = "tokenSecrec1234";

    public String generateToken(UserModel userModel) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + EXPITATION_TIME);

        return Jwts.builder()
                .setSubject(userModel.getUsername())
                .setIssuer(ISSUER)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return true;
        } catch (Exception error) {
            return false;
        }
    }

}
