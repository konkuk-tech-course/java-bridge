package bridge.service;

public class BridgeService {
    private static class InstanceHolder {
        private static final BridgeService INSTANCE = new BridgeService();
    }

    public static BridgeService getInstance() {
        return BridgeService.InstanceHolder.INSTANCE;
    }
}
