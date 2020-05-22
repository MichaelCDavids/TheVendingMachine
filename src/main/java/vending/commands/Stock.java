package vending.commands;

import vending.ExtendableVendingMachine;
import vending.Input;
import vending.product.*;

public class Stock implements Command {
    ExtendableVendingMachine extendableVendingMachine;

    public Stock( ExtendableVendingMachine extendableVendingMachine){
        this.extendableVendingMachine = extendableVendingMachine;
    }
    public String execute( Input input ) {
        if (input.getProduct().toLowerCase().equals("softdrink")){
            return "There is "+extendableVendingMachine.getStock(new SoftDrink())+" soft-drink(s) left in stock";
        }
        if (input.getProduct().toLowerCase().equals("muffin")){
            return "There is "+extendableVendingMachine.getStock(new Muffin())+" muffin(s) left in stock";
        }
        if (input.getProduct().toLowerCase().equals("saltysnack") && input.getQuantity() >= 1){
            return "There is "+extendableVendingMachine.getStock(new SaltySnack())+" salty-snack(s) left in stock";
        }
        if (input.getProduct().toLowerCase().equals("chocolate") && input.getQuantity() >= 1){
            return "There is "+extendableVendingMachine.getStock(new Chocolate())+" chocolate(s) left in stock";
        }
        return "There is "+extendableVendingMachine.getStock(new Product())+" product(s) left in stock";
    }
}
