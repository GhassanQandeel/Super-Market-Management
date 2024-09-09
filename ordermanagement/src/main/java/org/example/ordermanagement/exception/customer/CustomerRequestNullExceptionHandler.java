package org.example.ordermanagement.exception.customer;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class CustomerRequestNullExceptionHandler extends RuntimeException{
    private Code code;
    public CustomerRequestNullExceptionHandler() {
        super("Customer request is null");
    }
    public CustomerRequestNullExceptionHandler(String message) {
        super(message);
    }

    public CustomerRequestNullExceptionHandler(String message,Code code) {
        super(message);
        this.code = code;
    }

}
