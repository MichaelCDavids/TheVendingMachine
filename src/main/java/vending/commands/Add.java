package vending.commands;

import vending.ExtendableVendingMachine;
import vending.Input;
import vending.product.Muffin;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class Add implements Command {
    ExtendableVendingMachine extendableVendingMachine;

    public Add( ExtendableVendingMachine extendableVendingMachine){
        this.extendableVendingMachine = extendableVendingMachine;
    }
    public String execute( Input input ) {
        if (input.getProduct().toLowerCase().equals("softdrink") && input.getQuantity() >= 1){
            extendableVendingMachine.addStock(new SoftDrink(), input.getQuantity());
            return "added "+input.getQuantity()+" softdrink(s) to stock";
        }
        if (input.getProduct().toLowerCase().equals("muffin") && input.getQuantity() >= 1){
            extendableVendingMachine.addStock(new Muffin(), input.getQuantity());
            return "added "+input.getQuantity()+" muffin(s) to stock";
        }
        if (input.getProduct().toLowerCase().equals("saltysnack") && input.getQuantity() >= 1){
            extendableVendingMachine.addStock(new SaltySnack(), input.getQuantity());
            return "added "+input.getQuantity()+" salty snack(s) to stock";
        }
        if (input.getProduct().toLowerCase().equals("chocolate") && input.getQuantity() >= 1){
            extendableVendingMachine.addStock(new SaltySnack(), input.getQuantity());
            return "added "+input.getQuantity()+" chocolate(s) to stock";
        }
        return "nothing added";
    }
}
