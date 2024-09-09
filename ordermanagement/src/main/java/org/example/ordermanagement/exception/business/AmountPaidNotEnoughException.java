package org.example.ordermanagement.exception.business;

public class AmountPaidNotEnoughException extends RuntimeException {
    public AmountPaidNotEnoughException() {
        super("Amount paid not enough");
    }
    public AmountPaidNotEnoughException(String message) {
        super(message);
    }


}
