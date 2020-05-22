package vending;

import vending.commands.*;
import vending.product.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ExtendableVendingMachine {

    private int chocolateStock;
    private int softDrinkStock;
    private int saltySnackStock;
    private int muffinStock;

    public ExtendableVendingMachine(int chocolatesQty, int softDrinkQty, int saltySnacksQty, int muffinStockQty){
        this.chocolateStock = chocolatesQty;
        this.softDrinkStock = softDrinkQty;
        this.saltySnackStock = saltySnacksQty;
        this.muffinStock = muffinStockQty;
    }

    public void buy( Product product){
        if (product instanceof SoftDrink){
            this.softDrinkStock--;
        }
        if(product instanceof Chocolate){
            this.chocolateStock--;
        }
        if(product instanceof SaltySnack){
            this.saltySnackStock--;
        }
        if(product instanceof Muffin){
            this.muffinStock--;
        }
    }

    public void buy( Product product, int qty){
        if (product instanceof SoftDrink){
            if(softDrinkStock-qty>=0){
                this.softDrinkStock-=qty;
            }
        }
        if(product instanceof Chocolate){
            if(chocolateStock-qty>=0){

                this.chocolateStock-=qty;
            }
        }
        if(product instanceof SaltySnack){
            if(saltySnackStock-qty>=0){
                this.saltySnackStock-=qty;
            }
        }
        if(product instanceof Muffin){
            if(muffinStock-qty>=0){
                this.muffinStock-=qty;
            }
        }
    }

    public void addStock(Product product){
        if (product instanceof SoftDrink){
            this.softDrinkStock+=3;
        }
        if(product instanceof Chocolate){
            this.chocolateStock+=3;
        }
        if(product instanceof SaltySnack){
            this.saltySnackStock+=3;
        }
        if(product instanceof Muffin){
            this.muffinStock+=3;
        }
    }

    public void addStock(Product product, int qty){
        if (product instanceof SoftDrink){
            this.softDrinkStock+=qty;
        }
        if(product instanceof Chocolate){
            this.chocolateStock+=qty;
        }
        if(product instanceof SaltySnack){
            this.saltySnackStock+=qty;
        }
        if(product instanceof Muffin){
            this.muffinStock+=qty;
        }
    }

    public int getStock(Product product){
        if (product instanceof SoftDrink){
           return this.softDrinkStock;
        }
        if(product instanceof Chocolate){
            return this.chocolateStock;
        }
        if(product instanceof SaltySnack){
            return this.saltySnackStock;
        }
        if(product instanceof Muffin){
            return this.muffinStock;
        }
        if(product instanceof Product){
            return this.saltySnackStock + this.softDrinkStock + this.chocolateStock + this.muffinStock;
        }
        return 0;
    }

}
