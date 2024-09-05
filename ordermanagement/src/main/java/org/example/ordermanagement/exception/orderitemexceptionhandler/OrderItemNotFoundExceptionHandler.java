package org.example.ordermanagement.exception.orderitemexceptionhandler;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemNotFoundExceptionHandler extends RuntimeException {

    private Code code;

    public OrderItemNotFoundExceptionHandler() {
        super();
    }

    public OrderItemNotFoundExceptionHandler(String message, Code code) {
    super(message);
    this.code = code;
    }

}
