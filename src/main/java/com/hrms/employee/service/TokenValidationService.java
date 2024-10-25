package com.hrms.employee.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenValidationService {

    private final RestTemplate restTemplate;

    public TokenValidationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String token) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            // URL do Auth Service para validação do token
            ResponseEntity<String> response = restTemplate.exchange(
                    "http://localhost:8081/auth/validateToken",  // Supondo que o Auth Service esteja rodando na porta 8081
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            return response.getStatusCode().is2xxSuccessful();  // Retorna true se a resposta for 200 OK
        } catch (Exception e) {
            return false;
        }
    }
}