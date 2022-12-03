package bridge.controller;

import bridge.domain.Bridge;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.function.Supplier;

public class GameController {
    private static BridgeService bridgeService = BridgeService.getInstance();
    private static InputView inputView = InputView.getInstance();
    private static OutputView outputView = OutputView.getInstance();

    private static class InstanceHolder {
        private static final GameController INSTANCE = new GameController();
    }

    public static GameController getInstance() {
        return GameController.InstanceHolder.INSTANCE;
    }

    public Bridge createBridge() {
        int lengthInput = requestNumberInput(inputView::readBridgeSize);
        return bridgeService.createBridge(lengthInput);
    }

    private int requestNumberInput(Supplier<Integer> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return requestNumberInput(supplier);
        }
    }
}
