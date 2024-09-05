package com.example.employeemanagement.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDetails{
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String path;
    private List<ErrorResponse> errors;
}
