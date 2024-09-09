package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemAdditionNullRequest extends RuntimeException {
    private Code code;
    private Long id;
    public OrderItemAdditionNullRequest() {
        super();
    }
    public OrderItemAdditionNullRequest(String message) {
        super(message);
    }
    public OrderItemAdditionNullRequest(String message, Code code, Long id) {
        super(message);
        this.code = code;
        this.id = id;
    }

}
