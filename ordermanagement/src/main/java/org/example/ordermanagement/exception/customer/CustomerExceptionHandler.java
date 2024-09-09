package org.example.ordermanagement.exception.customer;


import org.example.ordermanagement.exception.dto.ErrorResponse;
import org.example.ordermanagement.exception.dto.ErrorResponseDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(CustomerRequestNullExceptionHandler.class)
    public ResponseEntity<ErrorResponseDetails> handleCustomerRequestNullException(CustomerRequestNullExceptionHandler handler) {
        List<ErrorResponse> errorResponse = new ArrayList<>();
        errorResponse.add(new ErrorResponse(handler.getMessage(),handler.getCode()));
        ErrorResponseDetails errorResponseDetails = new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "/customers",
                errorResponse
        );

        return new ResponseEntity<>(errorResponseDetails, HttpStatus.BAD_REQUEST);
    }
}
