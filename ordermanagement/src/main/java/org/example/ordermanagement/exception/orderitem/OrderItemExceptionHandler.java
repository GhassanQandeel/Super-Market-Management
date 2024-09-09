package org.example.ordermanagement.exception.orderitem;

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


    @ExceptionHandler(OrderItemNotFound.class)
    public ResponseEntity<ErrorResponseDetails> orderItemNotFoundExceptionHandler(OrderItemNotFound oi) {
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
    @ExceptionHandler(OrderItemOrderNotFound.class)
    public ResponseEntity<ErrorResponseDetails> orderItemOrderNotFoundExceptionHandler(OrderItemOrderNotFound oi) {
        List<ErrorResponse> errorResponses=new ArrayList<>();
        errorResponses.add(new ErrorResponse(oi.getMessage(),oi.getCode()));
        ErrorResponseDetails errorResponseDetails=new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "/orders/"+ oi.getOrderId()+"/order-items",
                errorResponses
        );
        return new ResponseEntity<>(errorResponseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(OrderItemProductNotFound.class)
    public ResponseEntity<ErrorResponseDetails> orderItemProductNotFoundExceptionHandler(OrderItemProductNotFound oi) {
        List<ErrorResponse> errorResponses=new ArrayList<>();
        errorResponses.add(new ErrorResponse(oi.getMessage(),oi.getCode()));
        ErrorResponseDetails errorResponseDetails=new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "/orders/"+ oi.getOrderId()+"/order-items",
                errorResponses

        );
        return new ResponseEntity<>(errorResponseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderItemPriceNotFound.class)
    public ResponseEntity<ErrorResponseDetails> orderItemPriceNotFoundExceptionHandler(OrderItemPriceNotFound oi) {
        List<ErrorResponse> errorResponses=new ArrayList<>();
        errorResponses.add(new ErrorResponse(oi.getMessage(),oi.getCode()));
        ErrorResponseDetails errorResponseDetails=new ErrorResponseDetails(
          LocalDateTime.now(),
          HttpStatus.INTERNAL_SERVER_ERROR,
          "/orders/"+ oi.getOrderId()+"/order-items",
          errorResponses
        );
        return new ResponseEntity<>(errorResponseDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderItemAdditionNullRequest.class)
    public ResponseEntity<ErrorResponseDetails> orderItemAdditionNullRequestExceptionHandler(OrderItemAdditionNullRequest oi) {
        List<ErrorResponse> errorResponses=new ArrayList<>();
        errorResponses.add(new ErrorResponse(oi.getMessage(),oi.getCode()));
        ErrorResponseDetails errorResponseDetails=new ErrorResponseDetails(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                "/orders/"+oi.getId()+"/order-items",
                errorResponses
        );
        return new ResponseEntity<>(errorResponseDetails, HttpStatus.BAD_REQUEST);
    }




}
