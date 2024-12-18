package com.hrms.employee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // Mantemos o email para contato e finalização do cadastro
    @Column(unique = true, nullable = false)
    private String email;

    // Mantemos o telefone para eventual contato
    @Column(unique = true, nullable = true)
    private String phone;

    @Column(nullable = false)
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false)
    private Double salary;

    // Construtor auxiliar para criar Employee
    public Employee(String firstName, String lastName, String email, String phone, LocalDate hireDate, Department department, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.department = department;
        this.salary = salary;
    }
}
