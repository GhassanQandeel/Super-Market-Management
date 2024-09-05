package org.example.ordermanagement.exception.orderitemexceptionhandler;

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
public class OrderItemExceptionHandler {


    @ExceptionHandler(OrderItemNotFoundExceptionHandler.class)
    public ResponseEntity<ErrorResponseDetails> orderItemNotFoundExceptionHandler(OrderItemNotFoundExceptionHandler oi) {
        List<ErrorResponse> errorResponses=new ArrayList<>();
        errorResponses.add(new ErrorResponse(oi.getMessage(),oi.getCode()));
        ErrorResponseDetails errorResponseDetails=new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "/orders",
                errorResponses
        );

        return new ResponseEntity<>(errorResponseDetails, HttpStatus.NOT_FOUND);

    }
}
