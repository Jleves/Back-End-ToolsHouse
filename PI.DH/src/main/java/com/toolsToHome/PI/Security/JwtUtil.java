package com.toolsToHome.PI.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtUtil {

    private String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    public String extractUserName(String token) {
        return extractClaimUsername(token);
    }

    public Date extractExpiration(String token) {
        return extractClaimDate(token);
    }

    public Date extractClaimDate(String token){
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

    public String extractClaimUsername(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)//La informacion clave valor que queremos guardar
                .setSubject(subject)//username
                .setIssuedAt(new Date(System.currentTimeMillis()))//Fecha en que se crea
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 +60 * 50))//Fecha actual + Tiempo de expiracion
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();// La firma, ponemos el tipo de algoritmo y nuestra clave secreta.
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


}
