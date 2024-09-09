package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderNotFoundExceptionHandler extends RuntimeException {
    private Code code;
    public OrderNotFoundExceptionHandler() {
        super();
    }
    public OrderNotFoundExceptionHandler(String message,Code code) {
        super(message);
        this.code = code;
    }
}
