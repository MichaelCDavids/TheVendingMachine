package vending.exceptions;

public class InvalidProductException extends ProductNotFoundException{
    public InvalidProductException(  ) {
        super("InvalidProductException");
    }
}
