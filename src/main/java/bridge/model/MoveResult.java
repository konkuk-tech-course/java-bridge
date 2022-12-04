package bridge.model;// @ author ninaaano

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X"),
    BLANK(" ");

    private final String command;

    MoveResult(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isFail(){
        return this.equals(FAIL);
    }
}


