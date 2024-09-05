package com.example.employeemanagement.exception;

public class EmptyListException extends RuntimeException {
    public EmptyListException(){
        super();
    }
    public EmptyListException(String message){
        super(message);
    }
}
