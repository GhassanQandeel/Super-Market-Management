package com.example.employeemanagement.controller;

import com.example.employeemanagement.controller.request.CreatedEmployeeRequest;
import com.example.employeemanagement.controller.request.UpdatedEmployeeRequest;
import com.example.employeemanagement.exception.Code;
import com.example.employeemanagement.exception.EmployeeManagementException;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.controller.dto.EmployeeDTO;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.specification.EmployeeSpecification;
import com.example.employeemanagement.specification.dto.EmployeeSearch;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
     // Projection, interface-based projection
    // JPA Criteria Builder to implement filters




    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;



    @GetMapping
    public List<EmployeeDTO> getAllEmployees(
            EmployeeSearch employeeSearch
    ) {
        return employeeMapper.toEmployeeDTO(employeeService.getAllEmployees(employeeSearch));
    }


    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeMapper.toEmployeeDTO(employeeService.findEmployeeById(id));
    }



    @PostMapping
    public void createEmployee(@RequestBody @Valid CreatedEmployeeRequest createdEmployeeRequest) {
       if (createdEmployeeRequest == null)
            throw new EmployeeManagementException("Employee cannot be null",Code.NULLEMPLOYEE);

       employeeService.createEmployee(employeeMapper.toEmployee(createdEmployeeRequest));
    }



    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id,@Valid @RequestBody UpdatedEmployeeRequest updatedEmployeeRequest) {
         if (updatedEmployeeRequest == null) {
            throw new EmployeeManagementException("Employee cannot be null",Code.NULLEMPLOYEE);
        }
         employeeService.updateEmployee(id,employeeMapper.toEmployee(updatedEmployeeRequest));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
    @GetMapping("/role-count")
    public Integer getEmployeeRoleCount(@Valid @RequestParam("role") String role) {
        return employeeService.findNumberOfEmployeeForEachRole(role);
    }

    *//* @GetMapping("/{age}")
    public List<EmployeeDTO> findEmployeeByAgeGreaterThan(@PathVariable Integer age) {
        return employeeMapper.toEmployeeDTO(employeeService.findEmployeeByAgeGreaterThan(age));
    }*//*

    @GetMapping("/role-id")
    public @ResponseBody List<Map<Long, Role>> findRoleForEveryEmployeeId() {
        return employeeService.findRoleForEveryEmployeeId();
    }*/








}
