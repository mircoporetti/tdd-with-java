package me.mircoporetti.tddwithjava.backtothecheckout.exception;

public class ProductNotInPriceListException extends RuntimeException{
    public ProductNotInPriceListException(String message) {
        super(message);
    }
}
