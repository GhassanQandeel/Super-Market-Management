package org.example.ordermanagement.exception.price;

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
public class PriceExceptionHandler  {
    @ExceptionHandler(PriceRequestNullException.class)
    public ResponseEntity<ErrorResponseDetails> handlePriceRequestException(PriceRequestNullException ex) {
        List<ErrorResponse> errors = new ArrayList<ErrorResponse>();
        errors.add(new ErrorResponse(ex.getMessage(), ex.getCode()));
        ErrorResponseDetails errorResponseDetails = new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "/prices",
                errors
        );
        return new ResponseEntity<>(errorResponseDetails, HttpStatus.BAD_REQUEST);
    }
}
