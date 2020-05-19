package vending.product;

public class SaltySnack extends Product {

    private int stockLevel;

    @Override
    public String description(){
        return "This is a Salty Snack";
    }

    public void setStockLevel( int stockLevel ) {
        this.stockLevel = stockLevel;
    }
}
