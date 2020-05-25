package vending.commands;

import vending.Input;
import vending.VendingMachine;
import vending.product.*;

public class Stock implements Command {

    VendingMachine vendingMachine;

    public Stock( VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void execute( Input input ) {
        if (input.getProduct().toLowerCase().equals("softdrink")){
            vendingMachine.getStock(new SoftDrink());
        }
        if (input.getProduct().toLowerCase().equals("muffin")){
            vendingMachine.getStock(new Muffin());
        }
        if (input.getProduct().toLowerCase().equals("saltysnack")){
            vendingMachine.getStock(new SaltySnack());
        }
        if (input.getProduct().toLowerCase().equals("chocolate")){
            vendingMachine.getStock(new Chocolate());
        }
        if (input.getProduct().toLowerCase().equals("all")){
            vendingMachine.getStock(new Product());
        }

    }
}
