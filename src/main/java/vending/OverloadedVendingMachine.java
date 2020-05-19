package vending;

import vending.product.Chocolate;
import vending.product.Product;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class OverloadedVendingMachine {
    SoftDrink softDrink;
    SaltySnack saltySnack;
    Chocolate chocolate;

    // should keep track of the number of each product type it has in stock.

    OverloadedVendingMachine(int softDrinkQty, int saltySnacksQty, int chocolatesQty){
        // set the stockLevel instance variables for each product in the constructor
    }

    public void buy(SoftDrink softDrink){

    }

    public void buy(SaltySnack saltySnack){

    }

    public void buy(Chocolate chocolate){

    }

    public void buy(Product product){

    }

    public void addStock(SoftDrink softDrink){

    }

    public void addStock(SaltySnack saltySnack){

    }

    public void addStock(Chocolate chocolate){
        // add 1 to this product
    }

    public void addStock(Product product){
        // add 3 to each product type
    }

    public void getStock(SoftDrink softDrink){

    }

    public void getStock(SaltySnack saltySnack){

    }

    public void getStock(Chocolate chocolate){
        // add 1 to this product
    }

    public void getStock(Product product){
        // add 3 to each product type
    }


    public static void main( String[] args ) {

    }


}
