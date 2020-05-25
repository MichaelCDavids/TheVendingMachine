package vending.exception;

public class SaltyCracksAllEatenException extends ProductNotFoundException {
    public SaltyCracksAllEatenException(  ) {
        super("Oops it looks like all the salty cracks has been eaten");
    }
}
