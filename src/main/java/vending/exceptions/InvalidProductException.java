package vending.exception;

public class InvalidProductException extends ProductNotFoundException{
    public InvalidProductException(  ) {
        super("InvalidProductException");
    }
}
