package bridge;

public enum LocationState {

    UP("U"),
    DOWN("D");

    private String state;
    private static final int GENERATE_DOWN=0;

    LocationState(String state) {
        this.state = state;
    }

    public static String convertGenerateToLocation(int generate) {
        if(generate == GENERATE_DOWN){
            return "D";
        }
        return "U";
    }

    public String getState() {
        return state;
    }
}
