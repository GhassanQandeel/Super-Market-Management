package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemNotFoundException extends RuntimeException {

    private Code code;

    public OrderItemNotFoundException() {
        super();
    }

    public OrderItemNotFoundException(String message, Code code) {
    super(message);
    this.code = code;
    }

}
