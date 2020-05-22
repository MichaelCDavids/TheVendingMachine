package vending;

public class Output {
    private String message;
    private boolean showPrompt;

    public Output(String msg, boolean showPrompt){
        this.message = msg;
        this.showPrompt = showPrompt;
    }

    public String getMessage(){
        return this.message;
    }
    public boolean showPrompt(){
        return this.showPrompt;
    }
}
