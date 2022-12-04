package bridge.view;

import bridge.BridgeMaker;
import bridge.constraints.OXSign;

import java.util.List;

import static bridge.constraints.MoveCode.UPSIGN;

public class OutputConverter {
    private final BridgeMaker bridgeMaker;

    public OutputConverter(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

//    public String convertbridgeToMessage(List<String> bridge, int tryCount) {
//        StringBuilder stringBuilder = new StringBuilder();
//        bridge.stream()
//                .limit(tryCount)
//                .map(i -> )
//        return null;
//    }
//
//    public String convertMoveCodeToOxSign(String moveCode) {
//        if (moveCode.equals(UPSIGN.getStringCode())){
//            return OXSign.
//        }
//    }


}
