package vending;

import vending.commands.*;
import vending.product.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtendableVendingMachine extends VendingMachine{

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
            System.out.println("buying 1 soft-drink");
            this.softDrinkStock--;
        }
        if(product instanceof Chocolate){
            if(this.chocolateStock>0){
                System.out.println("buying 1 chocolate");
                this.chocolateStock--;
            }
        }
        if(product instanceof SaltySnack){
            System.out.println("buying 1 salty snack");
            this.saltySnackStock--;
        }
        if(product instanceof Muffin){
            System.out.println("buying 1 muffin");
            this.muffinStock--;
        }
    }

    public void buy( Product product, int qty){
        if (product instanceof SoftDrink){
            if(softDrinkStock-qty>=0){
                System.out.println("buying "+qty+" soft-drink(s)");
                this.softDrinkStock-=qty;
            } else {
                System.out.println("soft-drinks out of stock");
            }
        }
        if(product instanceof Chocolate){
            if(chocolateStock-qty>=0){
                System.out.println("buying "+qty+" chocolate(s)");
                this.chocolateStock-=qty;
            }else{
                System.out.println("chocolates out of stock");
            }
        }
        if(product instanceof SaltySnack){
            if(saltySnackStock-qty>=0){
                System.out.println("buying "+qty+" salty snack(s)");
                this.saltySnackStock-=qty;
            }else {
                System.out.println("salty-snacks out of stock");
            }
        }
        if(product instanceof Muffin){
            if(muffinStock-qty>=0){
                System.out.println("buying "+qty+" muffin(s)");
                this.muffinStock-=qty;
            }else {
                System.out.println("muffins out of stock");
            }
        }
    }

    public void addStock(Product product){
        if (product instanceof SoftDrink){
            System.out.println("added 3 soft-drinks to stock");
            this.softDrinkStock+=3;
        }
        if(product instanceof Chocolate){
            System.out.println("added 3 chocolates to stock");
            this.chocolateStock+=3;
        }
        if(product instanceof SaltySnack){
            System.out.println("added 3 salty snacks to stock");
            this.saltySnackStock+=3;
        }
        if(product instanceof Muffin){
            System.out.println("added 3 muffins to stock");
            this.muffinStock+=3;
        }
    }

    public void addStock(Product product, int qty){
        if (product instanceof SoftDrink){
            System.out.println("added "+qty+" soft-drink(s) to stock");
            this.softDrinkStock+=qty;
        }
        if(product instanceof Chocolate){
            System.out.println("added "+qty+" chocolate(s) to stock");
            this.chocolateStock+=qty;
        }
        if(product instanceof SaltySnack){
            System.out.println("added "+qty+" salty snack(s) to stock");
            this.saltySnackStock+=qty;
        }
        if(product instanceof Muffin){
            System.out.println("added "+qty+" muffin(s) to stock");
            this.muffinStock+=qty;
        }
    }

    public int getStock(Product product){
        if (product instanceof SoftDrink){
            System.out.println("soft-drinks in stock: "+this.softDrinkStock);
            return this.softDrinkStock;
        }
        if(product instanceof Chocolate){
            System.out.println("chocolates in stock: "+this.chocolateStock);
            return this.chocolateStock;
        }
        if(product instanceof SaltySnack){
            System.out.println("salty snacks in stock: "+this.saltySnackStock);
            return this.saltySnackStock;
        }
        if(product instanceof Muffin){
            System.out.println("muffins in stock: "+this.muffinStock);
            return this.muffinStock;
        }
        if(product instanceof Product){
            int number = this.saltySnackStock + this.softDrinkStock + this.chocolateStock + this.muffinStock;
            System.out.println("number of items in stock: "+number);
            return number;
        }
        return 0;
    }

    public static void main( String[] args ) {
        Scanner keyboard = new Scanner(System.in);
        ExtendableVendingMachine extendableVendingMachine = new ExtendableVendingMachine(1,2,3,4);
        Map<String, Command> listOfCommands = new HashMap<String, Command>();

        listOfCommands.put("buy",new Buy(extendableVendingMachine));
        listOfCommands.put("add",new Add(extendableVendingMachine));
        listOfCommands.put("stock",new Stock(extendableVendingMachine));
        listOfCommands.put("help",new Help());
        listOfCommands.put("exit",new Exit());
        Commands commands = new Commands(listOfCommands);

        Processor p = new Processor(commands);

        System.out.println("Extendable Vending Machine v1.0.0");

        while (true) {
            System.out.print("Enter command\n> ");
            if(!p.processInput(keyboard.nextLine())){
                break;
            }
        }
    }
}
