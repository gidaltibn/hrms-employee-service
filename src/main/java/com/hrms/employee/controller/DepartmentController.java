package com.hrms.employee.controller;

import com.hrms.employee.client.AuthClient;
import com.hrms.employee.dto.DepartmentDTO;
import com.hrms.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AuthClient authClient;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody DepartmentDTO departmentDTO, @RequestHeader("Authorization") String token) {
        ResponseEntity<String> authResponse = authClient.validateToken(token);

        if (authResponse.getStatusCode() == HttpStatus.OK) {
            // Aqui você pode processar o salvamento do departamento
            return ResponseEntity.ok("Departamento salvo com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Você não tem permissão para criar departamentos");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PutMapping
    public ResponseEntity<DepartmentDTO> update(@RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.update(departmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }
}
