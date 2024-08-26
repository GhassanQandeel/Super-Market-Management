package com.example.employeemanagement.exception;

public class DuplicatedRecordException extends RuntimeException{
    public DuplicatedRecordException(){
        super();
    }
    public DuplicatedRecordException(String message){
        super(message);
    }
}
