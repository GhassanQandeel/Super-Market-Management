package com.example.employeemanagement.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException  extends RuntimeException {
    private Code code;

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message,Code code) {
        super(message);
        this.code = code;
    }
}
