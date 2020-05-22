package vending.commands;

import vending.Input;

public class Help implements Command {

    public String execute( Input input ) {
        return "==================================================================" +
                "\nEnter one of these valid commands below:\n" +
                "\n\tbuy [product] - Buys you the one of your selected product from the vending machine" +
                "\n\tbuy [product] [quantity] - Buys you the quantity of your selected product from the vending machine" +
                "\n\tadd [product] - Adds 3 items of stock for selected product" +
                "\n\tadd [product] [quantity] - Adds the entered items of stock for selected product" +
                "\n\tstock [product] - number of stock for a product" +
                "\n\tstock - Displays the total items in stock in the vending machine" +
                "\n\thelp - Displays list of available commands" +
                "\n================================================================" ;
    }
}
