package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderItemProductNotFound extends RuntimeException {
    private Code code;
    private Long orderId;

    public OrderItemProductNotFound() {
        super("OrderItemProductNotFound");
    }
    public OrderItemProductNotFound(String message) {
        super(message);
    }
    public OrderItemProductNotFound(String message,Code code,Long orderId) {
        super(message);
        this.code = code;
        this.orderId = orderId;
    }

}
