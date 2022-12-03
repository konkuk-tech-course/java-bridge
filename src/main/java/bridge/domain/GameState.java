package bridge.domain;

public enum GameState {

    RIGHT("O"),
    WRONG("X"),
    EMPTY(" "),
    INIT_INDEX(-1),
    INIT_STATE("")
    ;

    private String state;
    private int index;
    GameState(String state) {
        this.state = state;
    }
    GameState(int index){
        this.index=index;
    }


    public String getState() {
        return state;
    }

    public int getIndex() {
        return index;
    }

}
