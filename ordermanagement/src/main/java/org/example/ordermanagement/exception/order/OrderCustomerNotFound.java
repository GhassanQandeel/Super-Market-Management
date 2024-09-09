package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderCustomerNotFound extends RuntimeException {
    private Code code;

    public OrderCustomerNotFound() {
        super();
    }
    public OrderCustomerNotFound(String message) {
        super(message);
    }
    public OrderCustomerNotFound(String message, Code code) {
        super(message);
        this.code = code;
    }

}
