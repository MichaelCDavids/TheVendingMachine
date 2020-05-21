package vending;

import vending.product.Chocolate;
import vending.product.Product;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class OverloadedVendingMachine {

    private int softDrinkStock;
    private int saltySnackStock;
    private int chocolateStock;

    public OverloadedVendingMachine(int softDrinkQty, int saltySnacksQty, int chocolatesQty){
        this.softDrinkStock = softDrinkQty;
        this.saltySnackStock = saltySnacksQty;
        this.chocolateStock =chocolatesQty;
    }

    public void buy(SoftDrink softDrink){
        if(this.softDrinkStock>0) {
            this.softDrinkStock--;
        }
    }

    public void buy(SaltySnack saltySnack){
        if(this.saltySnackStock>0){
            this.saltySnackStock--;
        }
    }

    public void buy(Chocolate chocolate){
        if(this.chocolateStock>0){
            this.chocolateStock--;
        }
    }

    public void buy(Product product){
        buy(new SoftDrink());
        buy(new SaltySnack());
        buy(new Chocolate());
    }

    public void buy(Product product, int qty){
        for (int i=0; i<qty;i++){
            buy(product);
        }
    }

    public void addStock(SoftDrink softDrink){
        this.softDrinkStock+=3;
    }

    public void addStock(SaltySnack saltySnack){
        this.saltySnackStock+=3;
    }

    public void addStock(Chocolate chocolate){
        this.chocolateStock+=3;
    }

    public void addStock(Product product){
        addStock(new Chocolate());
        addStock(new SoftDrink());
        addStock(new SaltySnack());
    }

    public void addStockQty(Chocolate chocolate, int quantity){
        this.chocolateStock+=quantity;
    }

    public void addStockQty(SaltySnack saltySnack, int quantity){
        this.saltySnackStock+=quantity;
    }

    public void addStockQty(SoftDrink softDrink, int quantity){
        this.softDrinkStock+=quantity;
    }

    private void addStockQty(Product product, int quantity){
        addStockQty(new Chocolate(),quantity);
        addStockQty(new SaltySnack(),quantity);
        addStockQty(new SoftDrink(),quantity);
    }


    private void addStockQuantity(Product product, int qty){
        addStockQty(product,qty);
    }

    public void addStock(Product product, int qty){
        addStockQuantity(product,qty);
    }

    public int getStock(SoftDrink softDrink){
        return this.softDrinkStock;
    }

    public int getStock(SaltySnack saltySnack){
        return  this.saltySnackStock;
    }

    public int getStock(Chocolate chocolate){
        return this.chocolateStock;
    }

    public int getStock(){
        return this.chocolateStock + this.saltySnackStock + this.softDrinkStock;
    }


    public static void main( String[] args ) {
        System.out.println("Loyolo's Overloaded Vending Machine v1.0.0");
    }
}

