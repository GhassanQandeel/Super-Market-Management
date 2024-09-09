package org.example.ordermanagement.exception.order;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderFinalizeNullExceptionHandler extends RuntimeException {
    private Code code;
    private Long id;
    public OrderFinalizeNullExceptionHandler() {
        super("OrderFinalizeNullExceptionHandler");
    }
    public OrderFinalizeNullExceptionHandler(String message) {
        super(message);
    }
    public OrderFinalizeNullExceptionHandler(String message,Code code,Long id) {
        super(message);
        this.code = code;
        this.id = id;
    }


}
