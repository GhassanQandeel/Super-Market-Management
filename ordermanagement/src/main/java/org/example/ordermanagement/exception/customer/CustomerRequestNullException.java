package org.example.ordermanagement.exception.customer;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class CustomerRequestNullException extends RuntimeException{
    private Code code;
    public CustomerRequestNullException() {
        super("Customer request is null");
    }
    public CustomerRequestNullException(String message) {
        super(message);
    }

    public CustomerRequestNullException(String message, Code code) {
        super(message);
        this.code = code;
    }

}
