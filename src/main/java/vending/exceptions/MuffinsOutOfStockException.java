package vending.exception;

public class MuffinsOutOfStockException extends ProductNotFoundException {
    public MuffinsOutOfStockException(  ) {
        super("No luck today, all sod out.");
    }
}
