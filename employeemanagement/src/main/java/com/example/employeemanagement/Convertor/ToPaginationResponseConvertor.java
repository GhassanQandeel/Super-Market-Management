package com.example.employeemanagement.Convertor;

import com.example.employeemanagement.controller.dto.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.ResponseEntity;

public class ToPaginationResponseConvertor {

    public static PaginatedResponse<?> convertToPaginationResponse(Page<?> page){

        return new PaginatedResponse<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent()
        );
    }

}
