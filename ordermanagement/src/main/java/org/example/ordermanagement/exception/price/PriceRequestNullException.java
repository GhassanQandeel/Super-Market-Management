package org.example.ordermanagement.exception.price;

import lombok.Getter;
import org.example.ordermanagement.exception.dto.Code;
@Getter
public class PriceRequestNullException extends RuntimeException {
    private Code code;
    public PriceRequestNullException() {
        super();
    }
    public PriceRequestNullException(String message, Code code) {
        super(message);
        this.code = code;
    }


}
