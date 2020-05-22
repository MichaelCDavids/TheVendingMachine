package vending;

import vending.commands.Command;
import vending.commands.Commands;

public class Processor {
    Commands commands;

    public Processor(Commands commands){
        this.commands = commands;
    }

    public Output processInput( String input){

        Input userInput = new Input(input);

        if (commands.getCommand(userInput.getCommandType().name().toLowerCase()) instanceof Command){
            if (userInput.getCommandType().name().toLowerCase().equals("exit")){
                return new Output(commands.getCommand(userInput.getCommandType().name().toLowerCase()).execute(userInput),false);
            }
            return new Output(commands.getCommand(userInput.getCommandType().name().toLowerCase()).execute(userInput),true);
        }
        return new Output("type help for a list of valid commands",true);
    }
}
