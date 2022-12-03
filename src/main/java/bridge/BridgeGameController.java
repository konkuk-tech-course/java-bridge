package bridge;

import java.util.List;

public class BridgeGameController {
    public static List<String> initiallizeBridge(Integer bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
