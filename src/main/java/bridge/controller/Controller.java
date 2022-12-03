package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.util.RestartConverter.Q;

public class Controller {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int attempt = 1;
        outputView.gameStartPhrases();

        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        Bridge b = new Bridge(bridge, size);

        play(b, attempt);
    }
    public void play(Bridge b, int attempt) {
        boolean result;
        while(true) {
            result = successCrossingSquare(b);
            if(result) {
                break;
            }
            String restart = quitGame();
            if(restart.equals(Q.getRestart())) {
                break;
            }
            attempt++;
        }
        outputView.printResult(BridgeGame.bridges, result);
        outputView.printAttempt(attempt);
    }

    private boolean crossBridge(List<String> bridge) {
        boolean result = false;

        for(int i = 0; i < bridge.size(); i++) {
            outputView.chooseDirection();
            result = successCrossedBridge(bridge.get(i));
            outputView.printMap(BridgeGame.bridges);
            if(!result) return false;
        }
        return result;
    }
    private boolean successCrossedBridge(String square) {
        String upDown = inputView.readMoving();
        boolean success = upDown.equals(square);

        return BridgeGame.move(upDown,success);
    }
    public boolean successCrossingSquare(Bridge bridge) {
        BridgeGame.clear();
        return crossBridge(bridge.getBridge());
    }

    public String quitGame() {
        outputView.inputRestartGame();
        return inputView.readGameCommand();
    }
}
