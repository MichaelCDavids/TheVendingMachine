package vending.exceptions;

public class SoftDrinksOutOfStockException extends ProductNotFoundException{

    public SoftDrinksOutOfStockException() {
        super("All soft drinks sold out");
    }
}
