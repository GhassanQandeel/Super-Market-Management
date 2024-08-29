package com.example.employeemanagement.service.dto;

import com.example.employeemanagement.controller.dto.EmployeeDTO;
import com.example.employeemanagement.model.Employee;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationEmployeeResponse {
    private int page;
    private int size;
    private Long totalNumberOfEmployees;
    private int totalPages;
    private List<EmployeeDTO> employees;
}
