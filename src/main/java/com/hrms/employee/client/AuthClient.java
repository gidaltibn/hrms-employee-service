package com.hrms.employee.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "auth-service", url = "http://localhost:8082/auth")
public interface AuthClient {
    @GetMapping("/validate")
    ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token);
}