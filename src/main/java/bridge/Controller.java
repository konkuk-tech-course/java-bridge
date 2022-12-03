package bridge;

import bridge.util.RestartConverter;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.RestartConverter.Q;
import static bridge.util.RestartConverter.R;

public class Controller {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public boolean crossBridge(List<String> bridge) {
        boolean result = false;

        System.out.println(bridge);

        for(int i = 0; i < bridge.size(); i++) {
            String upDown = inputView.readMoving();
            boolean success = upDown.equals(bridge.get(i));

            result = BridgeGame.move(upDown,success);
            System.out.println(result);//
            outputView.printMap(BridgeGame.bridges);
            if(!result) return false;
        }
        return result;
    }

    public void restartGame() {
        String restart;
        boolean result;
        int attempt = 1;
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        do {
            BridgeGame.clear();
            result = crossBridge(bridge);
            if(result) {
               break;
            }
            restart = inputView.readGameCommand();
            if(restart.equals(Q.getRestart())) {
                break;
            }
            attempt++;
            System.out.println(restart);
        } while (restart.equals(R.getRestart()));

        outputView.printResult(BridgeGame.bridges,result, attempt);
    }
}
