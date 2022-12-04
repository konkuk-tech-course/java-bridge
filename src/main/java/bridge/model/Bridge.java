package bridge.model;// @ author ninaaano

import java.util.List;

public class Bridge {

    private List<String> bridgePath;

    public Bridge(List<String> bridgePath) {
        this.bridgePath = bridgePath;
    }

    public MoveResult correctPath(String command, int count){
        boolean match = bridgePath.get(count).equals(command);
        return MoveResult.toMatch(command,match);
    }

    public boolean isEnd(int count){
        return bridgePath.size() == count;
    }
}
