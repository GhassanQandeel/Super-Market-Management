package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;

@Getter
public class OrderCreationRequestNullException extends RuntimeException{
    private Code code;
    public OrderCreationRequestNullException() {
        super();
    }
    public OrderCreationRequestNullException(Code code) {
        this.code = code;
    }
    public OrderCreationRequestNullException(String message, Code code) {
        super(message);
        this.code = code;
    }
}
