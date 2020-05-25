package vending.exception;

public class ChocolatesAllGoneException extends ProductNotFoundException {
    public ChocolatesAllGoneException( ) {
        super("Chocolates have all been bought");
    }
}
