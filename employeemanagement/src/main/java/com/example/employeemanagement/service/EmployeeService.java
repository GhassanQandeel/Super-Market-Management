package com.example.employeemanagement.service;

import com.example.employeemanagement.Convertor.DateOfBirthConvertor;
import com.example.employeemanagement.exception.Code;
import com.example.employeemanagement.exception.EmployeeNotFoundException;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.projections.EmployeeProjections;
import com.example.employeemanagement.repository.CustomEmployeeRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.specification.EmployeeSpecification;
import com.example.employeemanagement.specification.dto.EmployeeSearch;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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
    private CustomEmployeeRepository customEmployeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;


    public ResponseEntity<?> getAllEmployees(EmployeeSearch employeeSearch, int pageNo, int pageSize) {

        ResponseEntity<?> response;


        if( (pageNo < 0) && (pageSize < 0))
            response=ResponseEntity.ok(employeeRepository.findAll(new EmployeeSpecification(employeeSearch)));
        else
            response = ResponseEntity.ok(employeeRepository.findAll(new EmployeeSpecification(employeeSearch),PageRequest.of(pageNo, pageSize)));


        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        }
        throw new EmployeeNotFoundException("There are no employees",Code.EMPTYEMPLOYEELIST);

    }

    public List<EmployeeProjections> findAllEmployeesBySomeAttributes() {
     return employeeRepository.findAllEmployeesBySomeAttributes();
    }




    public Employee findEmployeeById(Long id) {
        List<Employee> employee = customEmployeeRepository.getEmployeeById(id);
        if (employee.isEmpty())
            throw new  EmployeeNotFoundException("There are no employee with this id :"+id,Code.NOTFOUNDEMPLOYEE);
        return employee.get(0);

    }

    public void createEmployee(Employee employee) {
                employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
         if(!employeeRepository.existsById(id)){
            throw new  EmployeeNotFoundException("There are no employee with this id : "+id+" to Delete it",Code.NOTFOUNDEMPLOYEE);
         }
         employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id,@NotNull Employee employee) {

            if (!employeeRepository.existsById(id))
                throw new  EmployeeNotFoundException("There are no employee with this id : "+id+" to Update it",Code.NOTFOUNDEMPLOYEE);
            employee.setId(id);
            employeeRepository.save(employee);
    }




















/*
    public List<Employee> findEmployeeByEmail(String email) {
        List<Employee> employee = employeeRepository.findByEmail(email);
            return employee;
    }

    public List<Employee> findEmployeeByNameAndOrderBy(String name, Sort sort) {
     List<Employee> employee = employeeRepository.findEmployeeByNameAndOrderBy(name,sort.descending());

        return employee;
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
*/


}

