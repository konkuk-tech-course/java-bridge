package bridge.domain;

import bridge.util.ExceptionCode;
import bridge.util.RestartConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.util.Constant.*;
import static bridge.util.ExceptionCode.INVALID_QUIT_ANSWER;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static List<List<String>> bridges = new ArrayList<>();
    private BridgeGame() {
    }

    public static void clear() {
        bridges = new ArrayList<>();
        bridges = List.of(new ArrayList<>(), new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean move(String input, boolean success) {
        if(Objects.equals(input, U.getValue())) {
            bridges.get(0).add(successCrossBridge(success));
            bridges.get(1).add(BLANK.getValue());
        }
        if(Objects.equals(input, D.getValue())) {
            bridges.get(0).add(BLANK.getValue());
            bridges.get(1).add(successCrossBridge(success));
        }
        return success;
    }
    private static String successCrossBridge(boolean success){
        if(success) {
            return O.getValue();
        }
        return X.getValue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(String restart) {
        return RestartConverter.result(restart);
    }
}
