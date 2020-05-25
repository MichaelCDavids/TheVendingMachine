package vending.exceptions;

public class MuffinsOutOfStockException extends ProductNotFoundException {
    public MuffinsOutOfStockException(  ) {
        super("No luck today, all sod out.");
    }
}
