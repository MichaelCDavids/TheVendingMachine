package vending.commands;

import vending.Input;
import vending.VendingMachine;
import vending.exceptions.ProductNotFoundException;
import vending.product.*;

public  class Buy implements Command {

    VendingMachine vendingMachine;

    public Buy( VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void execute( Input input ) throws ProductNotFoundException {


        if (input.getProduct().toLowerCase().equals("softdrink") && input.getQuantity() >= 1){
            vendingMachine.buy(new SoftDrink(), input.getQuantity());
        }
        else if (input.getProduct().toLowerCase().equals("muffin") && input.getQuantity() >= 1){
            vendingMachine.buy(new Muffin(), input.getQuantity());
        }

        else if (input.getProduct().toLowerCase().equals("saltysnack") && input.getQuantity() >= 1){
            vendingMachine.buy(new SaltySnack(), input.getQuantity());
        }
        else if (input.getProduct().toLowerCase().equals("chocolate") && input.getQuantity() >= 1){
            vendingMachine.buy(new Chocolate(), input.getQuantity());
        }
        else {
            vendingMachine.buy(new Product());
        }

    }
}
