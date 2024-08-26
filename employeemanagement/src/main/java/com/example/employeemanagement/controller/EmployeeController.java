package com.example.employeemanagement.controller;

import com.example.employeemanagement.controller.request.CreatedEmployeeRequest;
import com.example.employeemanagement.controller.request.UpdatedEmployeeRequest;
import com.example.employeemanagement.exception.EmptyListException;
import com.example.employeemanagement.exception.EmptyObjectException;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.controller.dto.EmployeeDTO;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.service.EmployeeService;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.toEmployeeDTO(employeeService.getAllEmployees());
    }


    @PostMapping
    public void createEmployee(@Valid @RequestBody CreatedEmployeeRequest createdEmployeeRequest) {
        if (createdEmployeeRequest==null)
            throw new EmptyListException("The employee cannot be null");
        else {
            Employee employee = employeeMapper.toEmployee(createdEmployeeRequest);
            employeeService.createEmployee(employee);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id,@Valid @RequestBody UpdatedEmployeeRequest updatedEmployeeRequest) {
        if (updatedEmployeeRequest==null)
            throw new EmptyObjectException("The employee must not be null");
        else
         employeeService.updateEmployee(id,employeeMapper.toEmployee(updatedEmployeeRequest));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/emp")
    public List<EmployeeDTO> getEmployeeByEmail(@Valid @RequestParam("email") String email) {
        List<Employee> employees = employeeService.findEmployeeByEmail(email);
        return employees.stream().map(employee -> employeeMapper.toEmployeeDTO(employee)).collect(Collectors.toList());
    }
    @GetMapping("/role-count")
    public Integer getEmployeeRoleCount(@Valid @RequestParam("role") String role) {
        return employeeService.findNumberOfEmployeeForEachRole(role);
    }
    @GetMapping("/{age}")
    public List<EmployeeDTO> findEmployeeByAgeGreaterThan(@PathVariable Integer age) {
        return employeeMapper.toEmployeeDTO(employeeService.findEmployeeByAgeGreaterThan(age));
    }
    @GetMapping("/role-id")
    public @ResponseBody List<Map<Long, Role>> findRoleForEveryEmployeeId() {
        return employeeService.findRoleForEveryEmployeeId();
    }





/*
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeMapper.toEmployeeDTO(employeeService.findEmployeeById(id));
    }*/



}
