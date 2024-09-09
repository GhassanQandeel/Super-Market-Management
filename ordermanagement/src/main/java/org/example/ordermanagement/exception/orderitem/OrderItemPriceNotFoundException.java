package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemPriceNotFoundException extends RuntimeException {
    private Code code;
    private Long orderId;
    public OrderItemPriceNotFoundException() {
        super("OrderItemPriceNotFound");
    }
    public OrderItemPriceNotFoundException(String message) {
        super(message);
    }
    public OrderItemPriceNotFoundException(String message, Code code, Long orderId) {
        super(message);
        this.code = code;
        this.orderId = orderId;
    }
}
