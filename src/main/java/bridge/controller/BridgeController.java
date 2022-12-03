package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.GameSet;
import bridge.service.ValidateMove;
import bridge.service.ValidateSize;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {


    InputView inputView;
    OutputView outputView;
    ValidateSize validateSize;
    ValidateMove validateMove;
    BridgeMaker bridgeMaker;
    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validateSize = new ValidateSize();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.validateMove = new ValidateMove();
    }

    public void start(){
        int size = readBridgeValidate();
        List<String> statementBridge = bridgeMaker.makeBridge(size);
        System.out.println("statementBridge = " + statementBridge);;
        moveStart(statementBridge,size);
    }

    private void moveStart(List<String> statementBridge, int size) {
        BridgeGame bridgeGame = new BridgeGame(statementBridge);
        int idx=0;
        boolean retry=true;
        while(retry){
            if(!bridgeGame.move(readMovingValidate())){
                GameSet gameSet = new GameSet();
                gameSet.retryOrQuit(inputView.readGameCommand());
            }
        }

    }


    private int readBridgeValidate(){
        int size=0;
        try{
            outputView.printInputSize();
            size = validateSize.validate(inputView.readBridgeSize());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readBridgeValidate();
        }
        return size;
    }


    private String readMovingValidate(){
        String move=null;
        try{
            outputView.printInputMove();
            move = validateMove.validate(inputView.readMoving());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readMovingValidate();
        }
        return move;
    }
    private int readCommendValidate(){
        int size=0;
        try{
            outputView.printInputSize();
            size = validateSize.validate(inputView.readBridgeSize());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readBridgeValidate();
        }
        return size;
    }

}
