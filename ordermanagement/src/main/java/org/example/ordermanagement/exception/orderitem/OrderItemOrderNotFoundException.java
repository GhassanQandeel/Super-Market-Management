package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderItemOrderNotFoundException extends RuntimeException {
    private Code code;
    private Long orderId;
    public OrderItemOrderNotFoundException() {
        super("OrderItemOrderNotFound");
    }
    public OrderItemOrderNotFoundException(String message) {
        super(message);
    }
    public OrderItemOrderNotFoundException(String message, Code code, Long orderId) {
        super(message);
        this.code = code;
        this.orderId = orderId;

    }

}
