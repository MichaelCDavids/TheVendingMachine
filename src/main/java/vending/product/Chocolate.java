package vending.product;

public class Chocolate extends  Product {

    private int stockLevel;

    @Override
    public String description(){
        return "This is a Chocolate";
    }

    public void setStockLevel( int stockLevel ) {
        this.stockLevel = stockLevel;
    }
}
