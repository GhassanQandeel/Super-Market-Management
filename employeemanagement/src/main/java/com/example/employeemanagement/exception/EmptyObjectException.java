package com.example.employeemanagement.exception;

public class EmptyObjectException extends RuntimeException {
    public EmptyObjectException() {
        super();
    }
    public EmptyObjectException(String message) {
        super(message);
    }
}
