package vending.commands;

import vending.ExtendableVendingMachine;
import vending.Input;
import vending.product.Chocolate;
import vending.product.Muffin;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

public class Buy implements Command {

    ExtendableVendingMachine extendableVendingMachine;

    public Buy( ExtendableVendingMachine extendableVendingMachine){
        this.extendableVendingMachine = extendableVendingMachine;
    }
    public String execute( Input input ) {
        if (input.getProduct().toLowerCase().equals("softdrink") && input.getQuantity() >= 1){
            if(extendableVendingMachine.getStock(new SoftDrink())-input.getQuantity() >= 0){
                extendableVendingMachine.buy(new SoftDrink(), input.getQuantity());
                return "bought "+input.getQuantity()+" softdrink(s)";
            }
            return "not enough soft drink stock left";
        }
        if (input.getProduct().toLowerCase().equals("muffin") && input.getQuantity() >= 1){
            if (extendableVendingMachine.getStock(new Muffin())-input.getQuantity() >= 0){
                extendableVendingMachine.buy(new Muffin(), input.getQuantity());
                return "bought "+input.getQuantity()+" muffin(s)";
            }
            return "not enough muffin stock left";
        }
        if (input.getProduct().toLowerCase().equals("saltysnack") && input.getQuantity() >= 1){
            if(extendableVendingMachine.getStock(new SaltySnack())-input.getQuantity() >= 0){
                extendableVendingMachine.buy(new SaltySnack(), input.getQuantity());
                return "bought "+input.getQuantity()+" salty snack(s)";
            }
            return "not enough salty snack stock left";
        }
        if (input.getProduct().toLowerCase().equals("chocolate") && input.getQuantity() >= 1){
            if (extendableVendingMachine.getStock(new Chocolate())-input.getQuantity() >= 0){
                extendableVendingMachine.buy(new Chocolate(), input.getQuantity());
                return "bought "+input.getQuantity()+" chocolate(s)";
            }
            return "not enough chocolate stock left";
        }
        return "Come back later when you've decided what you want to purchase";
    }
}
