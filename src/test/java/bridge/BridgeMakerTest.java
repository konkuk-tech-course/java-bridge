package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeNumberGenerator bridgeRandomNumberGenerator;
    BridgeMaker bridgeMaker;

    @BeforeEach
    void generator_호출() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @Test
    @DisplayName("입력한 만큼의 랜덤 값의 다리 생성 테스트")
    void 다리_생성_테스트() {
        Integer inputSize = 3;
        List<String> randomBridge = bridgeMaker.makeBridge(inputSize);
        Assertions.assertEquals(randomBridge.size(), 3, "bridge 크기가 잘못되었습니다");
    }

}