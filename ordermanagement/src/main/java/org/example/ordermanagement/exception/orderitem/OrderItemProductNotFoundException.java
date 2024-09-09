package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderItemProductNotFoundException extends RuntimeException {
    private Code code;
    private Long orderId;

    public OrderItemProductNotFoundException() {
        super("OrderItemProductNotFound");
    }
    public OrderItemProductNotFoundException(String message) {
        super(message);
    }
    public OrderItemProductNotFoundException(String message, Code code, Long orderId) {
        super(message);
        this.code = code;
        this.orderId = orderId;
    }

}
