package vending;

import vending.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {
        Scanner keyboard = new Scanner(System.in);
        ExtendableVendingMachine extendableVendingMachine = new ExtendableVendingMachine(1,2,3,4);
        Map<String, Command> listOfCommands = new HashMap<String, Command>();

        listOfCommands.put("buy",new Buy(extendableVendingMachine));
        listOfCommands.put("add",new Add(extendableVendingMachine));
        listOfCommands.put("stock",new Stock(extendableVendingMachine));
        listOfCommands.put("help",new Help());
        listOfCommands.put("exit",new Exit());
        Commands commands = new Commands(listOfCommands);

        Processor p = new Processor(commands);

        System.out.println("Extendable Vending Machine v1.0.0");

        while (true) {
            System.out.print("Enter command\n> ");
            Output output = p.processInput(keyboard.nextLine());
            System.out.println(output.getMessage());
            if(!output.showPrompt()){
                break;
            }
        }
    }
}
