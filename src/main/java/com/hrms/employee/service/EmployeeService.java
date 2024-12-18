package com.hrms.employee.service;

import com.hrms.employee.dto.EmployeeDTO;
import com.hrms.employee.model.Employee;
import com.hrms.employee.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDTO convertEntityToDTO(Employee employee)     {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getHireDate(), employee.getDepartment(), employee.getSalary());
    }

    private Employee convertDTOToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        return employee;
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(@Valid EmployeeDTO employeeDTO) {
        Employee employee = convertDTOToEntity(employeeDTO);
        employeeRepository.save(employee);
    }

    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }
        return convertEntityToDTO(employee);
    }

    public EmployeeDTO update(@Valid EmployeeDTO employeeDTO) {
        Employee employee = convertDTOToEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return convertEntityToDTO(employee);
    }

    public boolean delete(Long id) {
        employeeRepository.deleteById(id);
        return false;
    }

    public List<EmployeeDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByDepartment(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findBySalary(Double salary) {
        List<Employee> employees = employeeRepository.findBySalary(salary);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByHireDate(LocalDate hireDate) {
        List<Employee> employees = employeeRepository.findByHireDate(hireDate);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByEmail(String email) {
        List<Employee> employees = employeeRepository.findByEmail(email);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByPhone(String phone) {
        List<Employee> employees = employeeRepository.findByPhone(phone);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByFirstName(String firstName) {
        List<Employee> employees = employeeRepository.findByFirstName(firstName);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByLastName(String lastName) {
        List<Employee> employees = employeeRepository.findByLastName(lastName);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }

    public List<EmployeeDTO> findByDepartmentName(String departmentName) {
        List<Employee> employees = employeeRepository.findByDepartmentName(departmentName);
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTO.add(convertEntityToDTO(employee));
        }
        return employeesDTO;
    }
}
