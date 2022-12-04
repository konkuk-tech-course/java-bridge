package bridge;


public enum LocationState {

    UP("U", 1),
    DOWN("D", 0);

    private String state;
    private int stateNum;

    LocationState(String state, int stateNum) {
        this.state = state;
        this.stateNum=stateNum;
    }

    public int getStateNum() {
        return stateNum;
    }

    public static String convertGenerateToLocation(int generate) {
        if(generate == DOWN.stateNum){
            return DOWN.state;
        }
        return UP.state;
    }

    public String getState() {
        return state;
    }
}
