package vending.commands;

import vending.Input;
import vending.exceptions.ProductNotFoundException;

public interface Command {
    void execute( Input input) throws ProductNotFoundException;
}
