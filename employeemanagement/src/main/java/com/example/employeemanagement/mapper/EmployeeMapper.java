package com.example.employeemanagement.mapper;


import com.example.employeemanagement.controller.dto.PaginatedResponse;
import com.example.employeemanagement.controller.request.CreatedEmployeeRequest;
import com.example.employeemanagement.controller.request.UpdatedEmployeeRequest;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.controller.dto.EmployeeDTO;
import com.example.employeemanagement.projections.EmployeeProjections;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")

public interface EmployeeMapper {



    Employee toEmployee(CreatedEmployeeRequest createdEmployeeRequest);
    Employee toEmployee(UpdatedEmployeeRequest updatedEmployeeRequest);
    Employee toEmployee(EmployeeDTO employeeDTO);
    Employee toEmployee(Employee employee);
    Employee toEmployee(EmployeeProjections employeeProjections);



    EmployeeDTO toEmployeeDTO(Employee employee);

    List<EmployeeDTO> toEmployeeDTO(List<Employee> employees);
    List<Employee> toEmployeeList(List<EmployeeProjections> employeeProjections);



}
