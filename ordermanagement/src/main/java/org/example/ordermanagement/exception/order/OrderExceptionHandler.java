package org.example.ordermanagement.exception.order;

import org.example.ordermanagement.exception.dto.Code;
import org.example.ordermanagement.exception.dto.ErrorResponse;
import org.example.ordermanagement.exception.dto.ErrorResponseDetails;
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


@ControllerAdvice
public class OrderExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorResponse> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ErrorResponse(error.getDefaultMessage(), Code.NULL_CASHIER_ID));
        }
        ErrorResponseDetails details = new ErrorResponseDetails();
        details.setErrors(errors);
        details.setTimestamp(LocalDateTime.now());
        details.setPath("/orders");
        details.setStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }

    @ExceptionHandler(OrderNotFoundExceptionHandler.class)
    public ResponseEntity<ErrorResponseDetails> handleOrderNotFoundExceptionHandler(OrderNotFoundExceptionHandler oHandler) {

        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(oHandler.getMessage(), Code.ORDER_NOT_FOUND));
        ErrorResponseDetails details = new ErrorResponseDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND, "/orders", errors);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
    }

    @ExceptionHandler(OrderCreationRequestNullExceptionHandler.class)
    public ResponseEntity<ErrorResponseDetails> handleOrderCreationRequestNullExceptionHandler(OrderCreationRequestNullExceptionHandler oHandler) {
        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(oHandler.getMessage(), Code.CREATION_ORDER_NULL));
        ErrorResponseDetails details = new ErrorResponseDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "/orders", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);

    }


    @ExceptionHandler(OrderCustomerNotFound.class)
    public ResponseEntity<ErrorResponseDetails> handleOrderCustomerNotFoundExceptionHandler(OrderCustomerNotFound oHandler) {
        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(oHandler.getMessage(),oHandler.getCode()));
        ErrorResponseDetails details = new ErrorResponseDetails(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, "/orders", errors);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }

    @ExceptionHandler(OrderFinalizeNullExceptionHandler.class)
    public ResponseEntity<ErrorResponseDetails> handleOrderFinalizeNullExceptionHandler(OrderFinalizeNullExceptionHandler oHandler) {
        List<ErrorResponse> errors = new ArrayList<>();
        errors.add(new ErrorResponse(oHandler.getMessage(),oHandler.getCode()));
        ErrorResponseDetails details = new ErrorResponseDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "/orders", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }




}

