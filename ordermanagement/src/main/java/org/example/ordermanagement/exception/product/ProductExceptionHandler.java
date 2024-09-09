package org.example.ordermanagement.exception.product;

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
public class ProductExceptionHandler {

    @ExceptionHandler(ProductRequestNullException.class)
    public ResponseEntity<ErrorResponseDetails> handleProductRequestNullException(ProductRequestNullException e) {
        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(e.getMessage(), e.getCode()));
        ErrorResponseDetails errorResponseDetails = new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "/products",
                errors
        );
        return new ResponseEntity<>(errorResponseDetails, HttpStatus.BAD_REQUEST);
    }


}
