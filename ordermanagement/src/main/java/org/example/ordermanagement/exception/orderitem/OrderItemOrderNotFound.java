package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderItemOrderNotFound extends RuntimeException {
    private Code code;
    private Long orderId;
    public OrderItemOrderNotFound() {
        super("OrderItemOrderNotFound");
    }
    public OrderItemOrderNotFound(String message) {
        super(message);
    }
    public OrderItemOrderNotFound(String message,Code code,Long orderId) {
        super(message);
        this.code = code;
        this.orderId = orderId;

    }

}
