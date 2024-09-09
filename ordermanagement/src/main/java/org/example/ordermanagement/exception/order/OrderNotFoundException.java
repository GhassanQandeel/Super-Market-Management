package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderNotFoundException extends RuntimeException {
    private Code code;
    public OrderNotFoundException() {
        super();
    }
    public OrderNotFoundException(String message, Code code) {
        super(message);
        this.code = code;
    }
}
