package vending;

import vending.commands.*;
import vending.product.Chocolate;
import vending.product.Product;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OverloadedVendingMachine extends VendingMachine {

    private int softDrinkStock;
    private int saltySnackStock;
    private int chocolateStock;

    public OverloadedVendingMachine(int softDrinkQty, int saltySnacksQty, int chocolatesQty){
        this.softDrinkStock = softDrinkQty;
        this.saltySnackStock = saltySnacksQty;
        this.chocolateStock = chocolatesQty;
    }

    public void buy(SoftDrink softDrink){
        if(this.softDrinkStock>0) {
            this.softDrinkStock--;
            System.out.println("bought soft-drink");
        }
    }

    public void buy(SaltySnack saltySnack){
        if(this.saltySnackStock>0){
            this.saltySnackStock--;
            System.out.println("bought salty snack");
        }
    }

    public void buy(Chocolate chocolate){
        if(this.chocolateStock>0){
            this.chocolateStock--;
            System.out.println("bought chocolate");
        }
    }

    public void buy(Product product){
        buy(new SoftDrink());
        buy(new SaltySnack());
        buy(new Chocolate());
    }

    public void buy(Product product, int qty){
        for (int i=0; i<qty;i++){
            if ( product instanceof SoftDrink){
                buy(new SoftDrink());
            } else if ( product instanceof SaltySnack){
                buy(new SaltySnack());
            } else if ( product instanceof Chocolate){
                buy(new Chocolate());
            } else {
                buy(new Product());;
            }

        }
    }



    public void addStock(SoftDrink softDrink){
        System.out.println("added 3 soft-drinks");
        this.softDrinkStock+=3;
    }

    public void addStock(SaltySnack saltySnack){
        System.out.println("added 3 salty snacks");
        this.saltySnackStock+=3;
    }

    public void addStock(Chocolate chocolate){
        System.out.println("adding 3 chocolates");
        this.chocolateStock+=3;
    }

    public void addStock(Product product){
        System.out.println("adding...");
        addStock(new Chocolate());
        addStock(new SoftDrink());
        addStock(new SaltySnack());
    }

    public void addStock(Product product, int qty){
        addStockQuantity(product,qty);
    }

    private void addStockQuantity(Product product, int qty){
        addStockQty(product,qty);
    }

    private void addStockQty(Product product, int quantity){
        if ( product instanceof SoftDrink){
            System.out.println("adding "+quantity+" soft-drinks");
            addStockQty(new SoftDrink(),quantity);
        } else if ( product instanceof SaltySnack){
            System.out.println("adding "+quantity+" salty snacks");
            addStockQty(new SaltySnack(),quantity);
        } else if ( product instanceof Chocolate){
            System.out.println("adding "+quantity+" chocolates");
            addStockQty(new Chocolate(),quantity);
        } else {
            System.out.println("adding "+quantity+" of each");
            addStockQty(new SoftDrink(),quantity);
            addStockQty(new SaltySnack(),quantity);
            addStockQty(new Chocolate(),quantity);
        }
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

    @Override
    public int getStock( Product p ) {
        if ( p instanceof SoftDrink){
            return getStock(new SoftDrink());
        } else if ( p instanceof SaltySnack){
            return getStock(new SaltySnack());
        } else if ( p instanceof Chocolate){
            return getStock(new Chocolate());
        } else {
            return getStock();
        }
    }

    public int getStock(SoftDrink softDrink){
        System.out.println("soft-drinks left: "+this.softDrinkStock);
        return this.softDrinkStock;
    }

    public int getStock(SaltySnack saltySnack){
        System.out.println("salty snacks left: "+this.saltySnackStock);
        return  this.saltySnackStock;
    }

    public int getStock(Chocolate chocolate){
        System.out.println("chocolates left: "+this.chocolateStock);
        return this.chocolateStock;
    }

    public int getStock(){
        int number = this.chocolateStock + this.saltySnackStock + this.softDrinkStock;
        System.out.println("items in stock: "+number);
        return number;
    }

    public static void main( String[] args ) {
        System.out.println("Overloaded Vending Machine v1.0.0");
        Scanner keyboard = new Scanner(System.in);
        OverloadedVendingMachine overloadedVendingMachine = new OverloadedVendingMachine(1,2,3);

        Map<String, Command> listOfCommands = new HashMap<String, Command>();

        listOfCommands.put("buy",new Buy(overloadedVendingMachine));
        listOfCommands.put("add",new Add(overloadedVendingMachine));
        listOfCommands.put("stock",new Stock(overloadedVendingMachine));
        listOfCommands.put("help",new Help());
        listOfCommands.put("exit",new Exit());
        Commands commands = new Commands(listOfCommands);

        Processor p = new Processor(commands);

        while (true) {
            System.out.print("Enter command\n> ");
            if(!p.processInput(keyboard.nextLine())){
                break;
            }
        }
    }
}

