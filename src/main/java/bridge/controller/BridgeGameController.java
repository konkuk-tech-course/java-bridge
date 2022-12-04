package bridge.controller;// @ author ninaaano

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.GameStatus;
import bridge.model.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker();

    public BridgeGameController() {
        inputView.readBridgeSize();


    }



    public void run(){
        Bridge bridge = initGame();
        while(GameStatus.isPlay){
        }

    }


    private void createBrigde(){
        inputView.readBridgeSize();


    }

}
