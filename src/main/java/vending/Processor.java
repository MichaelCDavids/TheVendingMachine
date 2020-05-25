package vending;

import vending.commands.Command;
import vending.commands.Commands;

public class Processor {
    Commands commands;

    public Processor(Commands commands){
        this.commands = commands;
    }

    public boolean processInput( String input){

        Input userInput = new Input(input);

        if (commands.getCommand(userInput.getCommandType().name().toLowerCase()) instanceof Command){
            if (userInput.getCommandType().name().toLowerCase().equals("exit")){
                try {
                    commands.getCommand(userInput.getCommandType().name().toLowerCase()).execute(userInput);
                    return false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                commands.getCommand(userInput.getCommandType().name().toLowerCase()).execute(userInput);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("type help for a list of valid commands and products");
        return true;
    }
}
