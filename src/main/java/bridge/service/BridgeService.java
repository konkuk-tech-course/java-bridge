package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeLength;

public class BridgeService {
    private static class InstanceHolder {
        private static final BridgeService INSTANCE = new BridgeService();
    }

    public static BridgeService getInstance() {
        return BridgeService.InstanceHolder.INSTANCE;
    }

    public Bridge createBridge(int length) {
        BridgeLength bridgeLength = new BridgeLength(length);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeLength, bridgeMaker.makeBridge(length));
    }
}
