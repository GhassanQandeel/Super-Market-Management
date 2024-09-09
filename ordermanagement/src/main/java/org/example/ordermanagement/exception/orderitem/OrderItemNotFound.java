package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemNotFound extends RuntimeException {

    private Code code;

    public OrderItemNotFound() {
        super();
    }

    public OrderItemNotFound(String message, Code code) {
    super(message);
    this.code = code;
    }

}
