package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderFinalizeNullException extends RuntimeException {
    private Code code;
    private Long id;
    public OrderFinalizeNullException() {
        super("OrderFinalizeNullExceptionHandler");
    }
    public OrderFinalizeNullException(String message) {
        super(message);
    }
    public OrderFinalizeNullException(String message, Code code, Long id) {
        super(message);
        this.code = code;
        this.id = id;
    }


}
