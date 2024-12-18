package com.hrms.employee.repository;

import com.hrms.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findBySalary(Double salary);

    List<Employee> findByHireDate(LocalDate hireDate);

    List<Employee> findByEmail(String email);

    List<Employee> findByPhone(String phone);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByDepartmentName(String departmentName);
}
