package bridge.domain;

import bridge.BridgeMaker;
import bridge.constraints.MoveCode;
import bridge.constraints.OutputMessage;
import bridge.view.OutputView;

import java.util.List;

import static bridge.constraints.MoveCode.DOWNSIGN;
import static bridge.constraints.MoveCode.UPSIGN;
import static bridge.constraints.OutputMessage.BAR;

public class BridgeResultMaker {


    private final BridgeResultPerLine upLineResults = new BridgeResultPerLine(UPSIGN);

    private final BridgeResultPerLine downLineResults = new BridgeResultPerLine(DOWNSIGN);

    public void addResults(MoveCode moveCode, String moveResult) {
        upLineResults.addMoveResults(moveCode, moveResult);
        downLineResults.addMoveResults(moveCode, moveResult);
    }

    public void reset() {
        upLineResults.clear();
        downLineResults.clear();
    }

    public List<String> upLineResults() {
        return upLineResults.getResults();
    }

    public List<String> downLineResults() {
        return downLineResults.getResults();
    }

}
