package vending;

import vending.commands.Type;

public class Input {

    private String [] arguments;

    public Input(String argumentString){
        this.arguments = argumentString.split(" ");
    }

    public Type getCommandType() {
        return getCommandType(this.arguments[0]);
    }

    public String getProduct() {
        if (this.arguments.length >= 2){
            return arguments[1].toUpperCase();
        }
        return "";
    }

    public int getQuantity() {
        if (this.arguments.length > 2){
            return  Integer.valueOf(arguments[2]);
        }
        return  arguments[0].toLowerCase().equals("buy") ? Integer.valueOf("1") : Integer.valueOf("3");
    }


    private Type getCommandType( String arg){
        for (Type type : Type.values()) {
            if (type.name().equals(arg.toUpperCase())) {
                return type;
            }
        }
        return Type.HELP;
    }

    protected int getArgumentsLength(){
        return this.arguments.length;
    }
}
