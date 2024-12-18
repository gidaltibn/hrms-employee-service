package com.hrms.employee.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final Key jwtSecret;

    public JwtAuthenticationFilter() {
        String secret = System.getenv("JWT_SECRET");
        if (secret == null || secret.trim().isEmpty()) {
            throw new IllegalStateException("JWT_SECRET não configurado nas variáveis de ambiente.");
        }
        this.jwtSecret = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = extractToken(request);

        if (token != null && validateToken(token)) {
            Claims claims = extractClaims(token);
            String username = claims.getSubject();
            System.out.println("Token válido para usuário: " + username);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    private boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.err.println("Token inválido: " + e.getMessage());
            return false;
        }
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
