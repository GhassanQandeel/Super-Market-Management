package org.example.ordermanagement.exception.orderitem;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class OrderItemAdditionNullRequestException extends RuntimeException {
    private Code code;
    private Long id;
    public OrderItemAdditionNullRequestException() {
        super();
    }
    public OrderItemAdditionNullRequestException(String message) {
        super(message);
    }
    public OrderItemAdditionNullRequestException(String message, Code code, Long id) {
        super(message);
        this.code = code;
        this.id = id;
    }

}
