package com.example.employeemanagement.exception;


import lombok.Getter;

@Getter
public class EmployeeManagementException extends RuntimeException{
    private Code code;

    public EmployeeManagementException(){
    }

    public EmployeeManagementException(String message,Code code) {
        super(message);
        this.code = code;
    }


}
