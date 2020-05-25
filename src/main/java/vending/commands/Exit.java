package vending.commands;

import vending.Input;

public class Exit implements Command{

    public void execute( Input input ) {
        System.out.println("Thank you for using Loyolo's Vending Machine");
    }
}
