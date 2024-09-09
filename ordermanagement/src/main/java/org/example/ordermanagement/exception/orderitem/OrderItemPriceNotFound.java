package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemPriceNotFound extends RuntimeException {
    private Code code;
    private Long orderId;
    public OrderItemPriceNotFound() {
        super("OrderItemPriceNotFound");
    }
    public OrderItemPriceNotFound(String message) {
        super(message);
    }
    public OrderItemPriceNotFound(String message, Code code, Long orderId) {
        super(message);
        this.code = code;
        this.orderId = orderId;
    }
}
