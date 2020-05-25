package vending.commands;

import vending.Input;
import vending.VendingMachine;
import vending.product.Chocolate;
import vending.product.Muffin;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class Add implements Command {
    VendingMachine vendingMachine;

    public Add( VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public void execute( Input input ) {
        if (input.getProduct().toLowerCase().equals("softdrink") && input.getQuantity() >= 1){
            vendingMachine.addStock(new SoftDrink(), input.getQuantity());
        }
        if (input.getProduct().toLowerCase().equals("muffin") && input.getQuantity() >= 1){
            vendingMachine.addStock(new Muffin(), input.getQuantity());
        }
        if (input.getProduct().toLowerCase().equals("saltysnack") && input.getQuantity() >= 1){
            vendingMachine.addStock(new SaltySnack(), input.getQuantity());
        }
        if (input.getProduct().toLowerCase().equals("chocolate") && input.getQuantity() >= 1){
            vendingMachine.addStock(new Chocolate(), input.getQuantity());
        }
    }
}
