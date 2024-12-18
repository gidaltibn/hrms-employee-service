package com.hrms.employee.controller;

import com.hrms.employee.client.AuthClient;
import com.hrms.employee.dto.EmployeeDTO;
import com.hrms.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuthClient authClient;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody EmployeeDTO employeeDTO,
                                       @RequestHeader("Authorization") String token) {
        ResponseEntity<String> authResponse = authClient.validateToken(token);

        if (authResponse.getStatusCode() == HttpStatus.OK) {
            employeeService.save(employeeDTO);
            return ResponseEntity.ok("Funcionário salvo com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Você não tem permissão para criar funcionários");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (authClient.validateToken(token).getStatusCode() == HttpStatus.OK) {
            EmployeeDTO employee = employeeService.findById(id);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@Valid @RequestBody EmployeeDTO employeeDTO,
                                              @RequestHeader("Authorization") String token) {
        if (authClient.validateToken(token).getStatusCode() == HttpStatus.OK) {
            EmployeeDTO updated = employeeService.update(employeeDTO);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (authClient.validateToken(token).getStatusCode() == HttpStatus.OK) {
            boolean deleted = employeeService.delete(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll(@RequestHeader("Authorization") String token) {
        if (authClient.validateToken(token).getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(employeeService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}
