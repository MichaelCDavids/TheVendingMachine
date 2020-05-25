package vending;


import vending.commands.*;
import vending.exceptions.*;
import vending.product.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExceptionalVendingMachine extends VendingMachine{

    private int chocolateStock;
    private int softDrinkStock;
    private int saltySnackStock;
    private int muffinStock;

    public ExceptionalVendingMachine(int chocolatesQty, int softDrinkQty, int saltySnacksQty, int muffinStockQty){
        this.chocolateStock = chocolatesQty;
        this.softDrinkStock = softDrinkQty;
        this.saltySnackStock = saltySnacksQty;
        this.muffinStock = muffinStockQty;
    }

    public void buy( Product product, int qty ) throws ProductNotFoundException{
            if (product instanceof SoftDrink){
                if(softDrinkStock-qty>=0){
                    this.softDrinkStock-=qty;
                    System.out.println("bought "+qty+" softdrink(s)");
                }else{
                    throw new SoftDrinksOutOfStockException();
                }
            }

            if(product instanceof Chocolate){
                if(chocolateStock-qty>=0){
                    this.chocolateStock-=qty;
                    System.out.println("bought "+qty+" chocolate(s)");
                }else{
                    throw new ChocolatesAllGoneException();
                }
            }

            if(product instanceof SaltySnack){
                if(saltySnackStock-qty>=0){
                    this.saltySnackStock-=qty;
                    System.out.println("bought "+qty+" salty snack(s)");
                }else{
                    throw new SaltyCracksAllEatenException();
                }
            }
            if(product instanceof Muffin){
                if(muffinStock-qty>=0){
                    this.muffinStock-=qty;
                    System.out.println("bought "+qty+" muffin(s)");
                }else{
                    throw new MuffinsOutOfStockException();
                }
            }
            if (product instanceof Product && qty < 0) {
                throw new InvalidProductException();
            }
    }

    public int getStock( Product product ) {
        try {
            if (product instanceof SoftDrink){
                System.out.println("softdrink stock items left: "+this.softDrinkStock);
                return this.softDrinkStock;
            }
            else if(product instanceof Chocolate){
                System.out.println("chocolate stock items left: "+this.chocolateStock);
                return this.chocolateStock;
            }
            else if(product instanceof SaltySnack){
                System.out.println("salty snack stock items left: "+this.saltySnackStock);
                return this.saltySnackStock;
            }
            else if(product instanceof Muffin){
                System.out.println("muffin stock items left: "+this.muffinStock);
                return this.muffinStock;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void addStock( Product p, int i ) {
        try {
            if (p instanceof SoftDrink){
                System.out.println("added "+i+" soft-drink(s) to stock");
                this.softDrinkStock+=i;
            }
            if(p instanceof Chocolate){
                System.out.println("added "+i+" chocolate(s) to stock");
                this.chocolateStock+=i;
            }
            if(p instanceof SaltySnack){
                System.out.println("added "+i+" salty snack(s) to stock");
                this.saltySnackStock+=i;
            }
            if(p instanceof Muffin){
                System.out.println("added "+i+" muffin(s) to stock");
                this.muffinStock+=i;
            }
        }catch (Exception e){
            System.out.println("AddStockException");
        }
    }

    @Override
    public void buy( Product product ) {
        System.out.println("...");
    }

    public static void main( String[] args ) {
        Scanner keyboard = new Scanner(System.in);
        ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(1,2,3,4);

        Map<String, Command> listOfCommands = new HashMap<String, Command>();

        listOfCommands.put("buy",new Buy(exceptionalVendingMachine));
        listOfCommands.put("add",new Add(exceptionalVendingMachine));
        listOfCommands.put("stock",new Stock(exceptionalVendingMachine));
        listOfCommands.put("help",new Help());
        listOfCommands.put("exit",new Exit());
        Commands commands = new Commands(listOfCommands);

        Processor p = new Processor(commands);

        System.out.println("Exceptional Vending Machine v1.0.0");

        while (true) {
            System.out.print("Enter command\n> ");
            if(!p.processInput(keyboard.nextLine())){
                break;
            }
        }
    }
}
