package com.hrms.employee.repository;

import com.hrms.employee.dto.DepartmentDTO;
import com.hrms.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);
}
