package com.hrms.employee.dto;


import com.hrms.employee.model.Department;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Column(nullable = false)
    private LocalDate hireDate;
    private Department department;
    private Double salary;

    public EmployeeDTO(Long id, String firstName, String lastName, String email, String phone, LocalDate hireDate, Department department, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
