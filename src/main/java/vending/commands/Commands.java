package vending.commands;

import vending.Input;

import java.util.Map;

public class Commands {
    private Map<String, Command> availableCommands;

    public Commands( Map<String, Command> listOfCommands){
        this.availableCommands = listOfCommands;
    }

    public Command getCommand(String key){
        if (availableCommands.containsKey(key)){
            return this.availableCommands.get(key);
        }
        return new Help() {
            public void executeVoid( Input input ) throws Exception {

            }
        };
    }
}
