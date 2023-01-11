package com.project.employeepayroll.controller;

import com.project.employeepayroll.dto.EmpDetailsDTO;
import com.project.employeepayroll.dto.EmpEditDTO;
import com.project.employeepayroll.dto.EmpRegistrationDTO;
import com.project.employeepayroll.model.Employee;
import com.project.employeepayroll.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EmpController {
    @Autowired
    public EmpService empservice;

    @PostMapping("/empRegistration")
    public ResponseEntity<?> registerEmployee(@RequestBody EmpRegistrationDTO employee) {
        empservice.empRegistration(employee);
        return new ResponseEntity<>(Map.of("message", "Employee Registration done."), HttpStatus.CREATED);
    }

    @PutMapping("/empEdit/{id}")
    public ResponseEntity<?> updateUser( @PathVariable Long id, @RequestBody EmpEditDTO empEditDTO) {
        empservice.editEmployee(id, empEditDTO);
        return new ResponseEntity<>(Map.of("message", "Employee Updated Successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        empservice.deleteEmployee(id);
        return new ResponseEntity<>(Map.of("message", "User Deleted Successfully"), HttpStatus.OK);
    }

    @GetMapping("/singleEmployee/{id}")
    public Employee getSingleEmployee(@PathVariable Long id) {
        Employee employeeOne = empservice.getSingleEmployee(id);
        return employeeOne;
    }

    @GetMapping("/searchEmployee/{search}")
    public Employee getSingleEmployee(@PathVariable String search) {
        Employee employeeOne = empservice.searchEmployee(search);
        return employeeOne;
    }

    @GetMapping("/getEmployee")
    public List<EmpDetailsDTO> getAllUser() {
        return empservice.getAllEmployee();
    }

}
