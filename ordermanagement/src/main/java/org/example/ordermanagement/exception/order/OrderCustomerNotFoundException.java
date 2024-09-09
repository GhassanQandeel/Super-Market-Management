package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderCustomerNotFoundException extends RuntimeException {
    private Code code;

    public OrderCustomerNotFoundException() {
        super();
    }
    public OrderCustomerNotFoundException(String message) {
        super(message);
    }
    public OrderCustomerNotFoundException(String message, Code code) {
        super(message);
        this.code = code;
    }

}
