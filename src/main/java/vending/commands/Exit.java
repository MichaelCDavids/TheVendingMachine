package vending.commands;

import vending.Input;

public class Exit implements Command{

    public String execute( Input input ) {
        return "Thank you for using Loyolo's Vending Machine";
    }
}
