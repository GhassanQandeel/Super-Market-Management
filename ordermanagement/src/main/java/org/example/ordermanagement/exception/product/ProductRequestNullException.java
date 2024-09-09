package org.example.ordermanagement.exception.product;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class ProductRequestNullException extends RuntimeException {
    private final Code code;

    ProductRequestNullException(String message, Code code) {
        super(message);
        this.code = code;
    }
}
