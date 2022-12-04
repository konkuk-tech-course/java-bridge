package bridge.view;

import static bridge.constraints.MoveCode.*;

public class InputConverter {

    public static String convertToCode(Integer i) {
        if (isUpSign(i)){
            return UPSIGN.getStringCode();
        }
        if (isDownSign(i)) {
            return DOWNSIGN.getStringCode();
        }
        throw new IllegalArgumentException("[ERROR] Input을 변환 할 수 없습니다.");
    }

    private static boolean isDownSign(Integer i) {
        return i == DOWNSIGN.getIntegerCode();
    }

    private static boolean isUpSign(Integer i) {
        return i == UPSIGN.getIntegerCode();
    }
}
