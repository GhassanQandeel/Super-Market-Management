package com.example.employeemanagement.controller.dto;

import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<T> {
// Generic classes in java
// PaginatedResponse

    private int pageNumber;
    private int pageSize;
    private Long totalNumberOfElements;
    private int totalPages;
    private List<T> entityResponse;

}
