package com.gestionTrabajos.Anteproyecto;

/*import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthService {
    private Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(clsAnteproyecto anteproyecto) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600000);  // 1 hora

        // Convierte la Key a un arreglo de bytes
        byte[] keyBytes = secretKey.getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);

        return Jwts.builder()
                .setSubject(anteproyecto.getAtrTitulo())
                .claim("anteproyectoId", anteproyecto.getAtrIdentificador())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, base64Key) // Usa el arreglo de bytes
                .compact();
    }

    public Claims parseToken(String token) throws SignatureException {
        return Jwts.parserBuilder()
                .setSigningKey(base64Key) // Usa el arreglo de bytes
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}*/
