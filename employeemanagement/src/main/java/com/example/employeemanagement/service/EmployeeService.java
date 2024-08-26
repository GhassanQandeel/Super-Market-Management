package com.example.employeemanagement.service;

import com.example.employeemanagement.Convertor.DateOfBirthConvertor;
import com.example.employeemanagement.exception.EmptyListException;
import com.example.employeemanagement.exception.EmptyObjectException;
import com.example.employeemanagement.exception.RecordNotFoundException;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.repository.EmployeeRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    // Exception handler
    // JPQL queries
    // Write native queries in spring

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.find();

        if (!employees.isEmpty()) {
            return employees;
        }
        else {
            throw new EmptyListException("There no Employees");
        }

    }

    public Employee findEmployeeById(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        else {
            throw new RecordNotFoundException("Record with id = "+ id +" is not found");
        }

    }


    public void createEmployee(Employee employee) {
        if (employee == null) {
            throw new EmptyListException("Employee cannot be null");
        }
        employeeRepository.save(employee);
    }



    public void deleteEmployeeById(Long id) {
         if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
         }
         else {
             throw new RecordNotFoundException("Record with id = "+ id +" is not found to delete it ");
         }

    }

    public void updateEmployee(Long id,@NotNull Employee employee) {
        if (employee==null)
            throw new EmptyObjectException("Employee cannot be null");
        else {
            employee.setId(id);
            if (employeeRepository.existsById(id))
                employeeRepository.save(employee);
            else
                throw new RecordNotFoundException("Record with id = " + id + " is not found to update it ");
        }
    }

    public List<Employee> findEmployeeByEmail(String email) {
        List<Employee> employee = employeeRepository.findByEmail(email);
        if (employee!=null){
            return employee;
        }
        else
            throw new EmptyListException("List of emails  is not found");
    }

    public List<Employee> findEmployeeByNameAndOrderBy(String name, Sort sort) {
     List<Employee> employee = employeeRepository.findEmployeeByNameAndOrderBy(name,sort.descending());
        if (employee!=null){
            return employee;
        }
        else
            throw new EmptyListException("List of names  is not found");
    }

    public List<Map<Long, Role>> findRoleForEveryEmployeeId() {
        return employeeRepository.findRoleForEveryEmployeeId();
    }

    public Integer findNumberOfEmployeeForEachRole(String role) {
        return employeeRepository.findNumberOfEmployeeForEachRole(role);
    }

    public List<Employee> findEmployeeByAgeGreaterThan(Integer age) {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().filter(employee -> (DateOfBirthConvertor.convertDateOfBirth(employee.getDateOfBirth())>age)).collect(Collectors.toSet()).stream().toList();


    }


}

