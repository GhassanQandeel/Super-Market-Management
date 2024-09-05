package com.example.employeemanagement.exception;


import com.example.employeemanagement.exception.dto.ErrorResponse;
import com.example.employeemanagement.exception.dto.ErrorResponseDetails;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {



    //For Employee Management
    @ExceptionHandler(EmployeeManagementException.class)
    public ResponseEntity<ErrorResponseDetails> handleEmployeeManagementException(EmployeeManagementException e) {

        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(e.getMessage(),e.getCode()));
        ErrorResponseDetails errorResponseDetails = new ErrorResponseDetails(LocalDateTime.now(),HttpStatus.BAD_REQUEST,"/employee",errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDetails);
    }
    // for argument exception
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            List<ErrorResponse> errors = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            if(fieldError.getField().equals("name")){
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(),Code.NULLNAME));
            }
            else if (fieldError.getField().equals("email")&& Objects.equals(fieldError.getCode(), "NotBlank")) {
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(), Code.UNACCEPTEDEMAIL));
            }
            else if(fieldError.getField().equals("email")&& Objects.equals(fieldError.getCode(), "Email")){
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(), Code.NULLEMAIL));
            }
            else if (fieldError.getField().equals("dateOfBirth")) {
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(), Code.NULLDATEOFBIRTH));
            }
            else
                errors.add(new ErrorResponse(fieldError.getDefaultMessage(),Code.NULLEMPLOYEEROLE));
        }
        ErrorResponseDetails errorResponseDetails = new ErrorResponseDetails(LocalDateTime.now(),HttpStatus.BAD_REQUEST,"/employee",errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDetails);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponseDetails> handleEmployeeNotFoundException(EmployeeNotFoundException e) {

        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(e.getMessage(),e.getCode()));
        ErrorResponseDetails errorResponseDetails = new ErrorResponseDetails(LocalDateTime.now(),HttpStatus.NOT_FOUND,"/employee",errors);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDetails);
    }

}

