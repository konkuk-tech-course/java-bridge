package bridge.controller;

import bridge.view.OutputView;

public class GameController {
    private static class InstanceHolder {
        private static final GameController INSTANCE = new GameController();
    }

    public static GameController getInstance() {
        return GameController.InstanceHolder.INSTANCE;
    }
}
