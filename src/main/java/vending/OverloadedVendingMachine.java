package vending;

import vending.product.Chocolate;
import vending.product.Product;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class OverloadedVendingMachine {
    SoftDrink softDrink;
    SaltySnack saltySnack;
    Chocolate chocolate;

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

}
