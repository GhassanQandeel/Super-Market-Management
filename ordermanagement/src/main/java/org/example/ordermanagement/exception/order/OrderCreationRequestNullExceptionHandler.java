package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderCreationRequestNullExceptionHandler extends RuntimeException{
    private Code code;
    public OrderCreationRequestNullExceptionHandler() {
        super();
    }
    public OrderCreationRequestNullExceptionHandler(Code code) {
        this.code = code;
    }
    public OrderCreationRequestNullExceptionHandler( String message,Code code) {
        super(message);
        this.code = code;
    }
}
