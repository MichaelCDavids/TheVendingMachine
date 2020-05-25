package vending.commands;

import vending.Input;

public class Help implements Command {

    public void execute( Input input ) {
        System.out.println("==================================================================" +
                "\n Enter one of these valid commands below:" +
                "\n\tbuy [product] - Buys your selected product" +
                "\n\tbuy [product] [quantity] - Buys you the quantity of your selected product" +
                "\n\tadd [product] - Adds 3 items of stock for selected product" +
                "\n\tadd [product] [quantity] - Adds the entered items of stock for selected product" +
                "\n\tstock [product] - Displays stock left for a product" +
                "\n\tstock - Displays the total items in stock" +
                "\n\thelp - Displays list of available commands" +
                "\n================================================================" );
    }
}
