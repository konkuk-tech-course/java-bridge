package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.domain.constant.UserStatus;
import bridge.service.BridgeGame;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.constant.RetryOptions;

import java.util.function.Supplier;

public class GameController {
    private static BridgeService bridgeService = BridgeService.getInstance();
    private static BridgeGame bridgeGame = BridgeGame.getInstance();
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

    public void operate(User user, Bridge bridge) {
        while(user.getStatus() == UserStatus.PLAY) {
            String option = requestOptionInput(inputView::readMoving);
            bridgeGame.move(user, bridge, option);
            outputView.printMap(bridgeGame.makeResult(user, bridge));
            if (user.getStatus() == UserStatus.FAIL) {
                retry(user);
            }
        }
    }

    private void retry(User user) {
        String option = requestOptionInput(inputView::readGameCommand);
        if (option.equals(RetryOptions.RETRY.get())) {
            bridgeGame.retry(user);
        }
    }

    private String requestOptionInput(Supplier<String> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return requestOptionInput(supplier);
        }
    }

    public void finishGame(User user, Bridge bridge) {
        outputView.printResult(
                bridgeGame.makeResult(user, bridge),
                user.getStatus() == UserStatus.SUCCESS,
                user.getAttemptCount()
        );
    }
}
