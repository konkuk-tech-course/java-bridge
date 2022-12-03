package bridge;

import java.util.List;

public class BridgeAnalyze {
    String input;
    Integer index;
    List<String> bridgeInfo;
    public BridgeAnalyze(String input, Integer index, List<String> bridgeInfo) {
        this.input = input;
        this.index = index;
        this.bridgeInfo = bridgeInfo;
    }

    public Boolean analyze() {
        if (bridgeInfo.get(index).equals(input)) {
            return true;
        }
        return false;
    }
}
