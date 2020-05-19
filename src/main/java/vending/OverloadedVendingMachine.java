package vending;

import vending.product.Chocolate;
import vending.product.Product;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class OverloadedVendingMachine {
    Product product = new Product();
    SoftDrink softDrink = new SoftDrink();
    SaltySnack saltySnack = new SaltySnack();
    Chocolate chocolate = new Chocolate();

    public OverloadedVendingMachine(int softDrinkQty, int saltySnacksQty, int chocolatesQty){
        this.softDrink.setStockLevel(softDrinkQty);
        this.saltySnack.setStockLevel(saltySnacksQty);
        this.chocolate.setStockLevel(chocolatesQty);
    }

    public void buy(SoftDrink softDrink){
        if(getStock(softDrink)>0) {
            this.softDrink.setStockLevel(this.softDrink.getStockLevel() - 1);
        }
    }

    public void buy(SaltySnack saltySnack){
        if(getStock(saltySnack)>0){
            this.saltySnack.setStockLevel(this.saltySnack.getStockLevel()-1);
        }
    }

    public void buy(Chocolate chocolate){
        if(getStock(chocolate)>0){
            this.chocolate.setStockLevel(this.chocolate.getStockLevel()-1);
        }
    }

    public void buy(Product product){
        buy(this.softDrink);
        buy(this.chocolate);
        buy(this.saltySnack);
    }

    public void buy(Product product, int qty){
        for (int i=0; i<qty;i++){
            buy(product);
        }
    }

    public void addStock(SoftDrink softDrink){
        this.softDrink.setStockLevel(getStock(softDrink)+3);
    }

    public void addStock(SaltySnack saltySnack){
        this.saltySnack.setStockLevel(getStock(saltySnack)+3);
    }

    public void addStock(Chocolate chocolate){
        this.chocolate.setStockLevel(getStock(chocolate)+3);
    }

    public void addStock(Product product){
        addStock(this.softDrink);
        addStock(this.chocolate);
        addStock(this.saltySnack);
    }

    public void addStockQty(Chocolate chocolate, int quantity){
        this.chocolate.setStockLevel(getStock(chocolate)+quantity);
    }

    public void addStockQty(SaltySnack saltySnack, int quantity){
        this.saltySnack.setStockLevel(getStock(saltySnack)+quantity);
    }

    public void addStockQty(SoftDrink softDrink, int quantity){
        this.softDrink.setStockLevel(getStock(softDrink)+quantity);
    }

    void addStockQty(Product product, int quantity){
        addStockQty(this.softDrink,quantity);
        addStockQty(this.chocolate,quantity);
        addStockQty(this.saltySnack,quantity);
    }


    void addStockQuantity(Product product, int qty){
        addStockQty(product,qty);
    }

    public void addStock(Product product, int qty){
        addStockQuantity(product,qty);
    }

    public int getStock(SoftDrink softDrink){
        return this.softDrink.getStockLevel();
    }

    public int getStock(SaltySnack saltySnack){
        return  this.saltySnack.getStockLevel();
    }

    public int getStock(Chocolate chocolate){
        return this.chocolate.getStockLevel();
    }

    public int getStock(){
        return getStock(this.chocolate) + getStock(this.softDrink)+getStock(this.saltySnack);
    }


    public static void main( String[] args ) {
        System.out.println("Loyolo's Overloaded Vending Machine v1.0.0");
    }
}
