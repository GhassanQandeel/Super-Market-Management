package com.example.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

import static java.lang.String.valueOf;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), Arrays.asList(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<?> handleEmptyListException(EmptyListException e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), Arrays.asList(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    @ExceptionHandler(DuplicatedRecordException.class)
    public ResponseEntity<?> handleDuplicatedRecordException(DuplicatedRecordException e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), Arrays.asList(e.getMessage()));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

    }


    @ExceptionHandler(EmptyObjectException.class)
    public ResponseEntity<?> handleEmptyObjectException(EmptyObjectException e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getLocalizedMessage(), Arrays.asList(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);

    }







}

