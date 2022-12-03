package bridge;

import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void makeBridgeTest() {
        System.out.println(bridgeMaker.makeBridge(3));
        System.out.println(bridgeMaker.makeBridge(3));
        System.out.println(bridgeMaker.makeBridge(3));
        System.out.println(bridgeMaker.makeBridge(3));
    }
}
