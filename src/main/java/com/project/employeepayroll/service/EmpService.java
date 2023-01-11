package com.project.employeepayroll.service;

import com.project.employeepayroll.dto.EmpDetailsDTO;
import com.project.employeepayroll.dto.EmpEditDTO;
import com.project.employeepayroll.dto.EmpRegistrationDTO;
import com.project.employeepayroll.exception.Exception;
import com.project.employeepayroll.model.Employee;
import com.project.employeepayroll.repository.EmpRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void empRegistration(EmpRegistrationDTO empRegistrationDTO) {
        if (empRepository.findByDepartmentAndName(empRegistrationDTO.getDepartment(), empRegistrationDTO.getName()).isPresent()) {
            throw new Exception("Employee already Exist.");
        }
        empRepository.save(modelMapper.map(empRegistrationDTO, Employee.class));
    }

    public void editEmployee( Long id, EmpEditDTO editDTO) {
        Employee employee = empRepository
                .findById(id)
                .orElseThrow(() -> new Exception("Employee not found."));
        editDTO.setId(employee.getId());
        empRepository.save(modelMapper.map(editDTO, Employee.class));
    }

    public Employee getSingleEmployee(Long id) {
        Employee employee = empRepository.findById(id).orElseThrow(() -> new Exception("Employee Not found."));
        return employee;
    }

    public void deleteEmployee(Long id) {
        Employee userToBeDeleted = empRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee not found."));
        empRepository.delete(userToBeDeleted);
    }

    public List<EmpDetailsDTO> getAllEmployee() {
        List<EmpDetailsDTO> list = empRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmpDetailsDTO.class))
                .collect(Collectors.toList());
        if (list.size() == 0) {
            throw new Exception("No Employee in database.");
        }
        return list;
    }

    public Employee searchEmployee(String search) {
        Employee employee = empRepository.findByName(search).orElseThrow(() -> new Exception("Employee Not found."));
        return employee;
    }
}
