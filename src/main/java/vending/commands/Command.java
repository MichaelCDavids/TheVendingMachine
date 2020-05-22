package vending.commands;

import vending.Input;

public interface Command {
    String execute( Input input);
}
