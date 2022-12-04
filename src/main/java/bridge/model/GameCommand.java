package bridge.model;// @ author ninaaano

public enum GameCommand {
    PLAY("R"),
    STOP("Q");

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getProgerss(){
        return command;
    }
}
