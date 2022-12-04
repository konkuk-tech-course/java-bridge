package bridge.domain;

import bridge.constraints.MoveCode;

import java.util.ArrayList;
import java.util.List;

// u,d 받아서 결과 작성
public class BridgeResultPerLine {


    private static final String BLANK = " ";
    private final MoveCode moveCodes;

    private final List<String> results = new ArrayList<>();

    public BridgeResultPerLine(MoveCode moveCode) {
        this.moveCodes = moveCode;
    }

    public void addMoveResults(MoveCode moveCode, String moveResult) {
        if (this.moveCodes == moveCode) {
            results.add(moveResult);
            return;
        }
        results.add(BLANK);
    }

    public List<String> getResults() {
        return results;
    }

    public void clear() {
        results.clear();
    }
}
