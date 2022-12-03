package bridge;

import bridge.controller.GameController;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeService;
import bridge.service.UserService;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        OutputView outputView = OutputView.getInstance();
        GameController gameController = GameController.getInstance();
        outputView.printStartPhrase();
        User user = userService.createUser();
        Bridge bridge = gameController.createBridge();
        gameController.operate(user, bridge);
        gameController.finishGame(user, bridge);
    }
}
