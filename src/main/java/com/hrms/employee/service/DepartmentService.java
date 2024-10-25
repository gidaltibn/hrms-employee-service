package com.hrms.employee.service;

import com.hrms.employee.dto.DepartmentDTO;
import com.hrms.employee.model.Department;
import com.hrms.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentDTO convertEntityToDTO(Department department) {
        return new DepartmentDTO(department.getId(), department.getName(), department.getDescription());
    }

    private Department convertDTOToEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        return department;
    }

    @Autowired
    private DepartmentRepository departmentRepository;

    // Add the methods here
    //Salvar um departamento
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        Department department = convertDTOToEntity(departmentDTO);
        department = departmentRepository.save(department);
        return convertEntityToDTO(department);
    }

    //Buscar um departamento pelo id
    public DepartmentDTO findById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department == null) {
            return null;
        }
        return convertEntityToDTO(department);
    }

    //Atualizar um departamento
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        Department department = convertDTOToEntity(departmentDTO);
        department = departmentRepository.save(department);
        return convertEntityToDTO(department);
    }

    //Deletar um departamento
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    //Listar todos os departamentos
    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for (Department department : departments) {
            departmentDTOs.add(convertEntityToDTO(department));
        }
        return departmentDTOs;
    }

    //Buscar um departamento pelo nome
    public DepartmentDTO findByName(String name) {
        Department department = departmentRepository.findByName(name);
        if (department == null) {
            return null;
        }
        return convertEntityToDTO(department);
    }



}
