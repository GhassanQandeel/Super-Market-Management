package org.example.ordermanagement.exception.customer;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class CustomerNotFoundException extends RuntimeException {
    private Code code;
    public CustomerNotFoundException() {
        super();
    }
    public CustomerNotFoundException(String message,Code code) {
        super(message);
        this.code = code;
    }
}
