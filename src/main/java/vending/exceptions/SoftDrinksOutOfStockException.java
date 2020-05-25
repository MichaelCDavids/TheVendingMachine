package vending.exception;

public class SoftDrinksOutOfStockException extends ProductNotFoundException{

    public SoftDrinksOutOfStockException() {
        super("All soft drinks sold out");
    }
}
