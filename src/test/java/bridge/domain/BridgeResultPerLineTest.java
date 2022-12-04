package bridge.domain;

import bridge.constraints.MoveCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeResultPerLineTest {

    @Test
    @DisplayName("출력 값 테스트")
    void 게임_결과_출력_테스트() {
        List<String> bridge = List.of("U", "D", "D", "U", "D");
//        assertEquals(randomBridge.size(), 3, "bridge 크기가 잘못되었습니다");
    }

}