package bridge.view;

import static bridge.constraints.MoveCode.*;

public class InputConverter {

    public static String convertToCode(Integer i) {
        if (i == UPSIGN.getIntegerCode()){
            return UPSIGN.getStringCode();
        }
        if (i == DOWNSIGN.getIntegerCode()) {
            return DOWNSIGN.getStringCode();
        }
        throw new IllegalArgumentException("[ERROR] Input을 변환 할 수 없습니다.");
    }
}
