package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeMap {
    private List<String> playerMap;
    private List<String> bridgeInfo;
    private List<String> upperMap = new ArrayList<>();
    private List<String> lowerMap = new ArrayList<>();
    private List<List<String>> result;
    public BridgeMap(List<String> playerMap, List<String> bridgeInfo) {
        this.playerMap = playerMap;
        this.bridgeInfo = bridgeInfo;
        this.result = makeMap();
    }
    public List<List<String>> makeMap() {
        for (Integer i=0; i < playerMap.size(); i++) {
            if (playerMap.get(i).equals(bridgeInfo.get(i))) { makeCorrectMap(i); }
            if (!playerMap.get(i).equals(bridgeInfo.get(i))) { makeWrongMap(i); }
        }
        List<List<String>> result = new ArrayList<>(Arrays.asList(upperMap, lowerMap));
        return result;
    }

    public void makeCorrectMap(Integer i) {
        if (playerMap.get(i).equals("U")) {
            upperMap.add(" O ");
            lowerMap.add("   ");
        }
        if (playerMap.get(i).equals("D")) {
            upperMap.add("   ");
            lowerMap.add(" O ");
        }
    }

    public void makeWrongMap(Integer i) {
        if (playerMap.get(i).equals("U")) {
            upperMap.add(" X ");
            lowerMap.add("   ");
        }
        if (playerMap.get(i).equals("D")) {
            upperMap.add("   ");
            lowerMap.add(" X ");
        }
    }

    public List<List<String>> showMap() {
        return this.result;
    }
}
