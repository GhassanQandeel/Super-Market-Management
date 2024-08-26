package com.example.employeemanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
    private Boolean success;
    private LocalDateTime dateOfResponse;

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.success = false;
        this.dateOfResponse = LocalDateTime.now();
    }




}

