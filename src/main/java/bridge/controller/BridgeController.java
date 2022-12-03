package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.GameSet;
import bridge.service.Validate;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {


    InputView inputView;
    OutputView outputView;
    GameSet gameSet;
    Validate validate;
    BridgeMaker bridgeMaker;
    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validate = new Validate();
        this.gameSet=new GameSet();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start(){
        int size = readBridgeValidate();
        List<String> statementBridge = bridgeMaker.makeBridge(size);
        System.out.println("statementBridge = " + statementBridge);;
        moveStart(statementBridge,size);
    }

    private void moveStart(List<String> statementBridge, int size) {
        BridgeGame bridgeGame = new BridgeGame(statementBridge);
        boolean retry=true;
        while(keepMoving(size, bridgeGame, retry)){
            if(!bridgeGame.move(readMovingValidate())){
                retry = gameSet.isRetry(readCommendValidate(), bridgeGame);
            }
        }
        outputView.printResult(bridgeGame, gameSet.getGameResult());
    }

    private static boolean keepMoving(int size, BridgeGame bridgeGame, boolean retry) {
        return retry && size > bridgeGame.getNowIndex() + 1;
    }


    private int readBridgeValidate(){
        int size=0;
        try{
            outputView.printInputSize();
            size = validate.validateSize(inputView.readBridgeSize());
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
            move = validate.validateMove(inputView.readMoving());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readMovingValidate();
        }
        return move;
    }

    private String readCommendValidate(){
        String command=null;
        try{
            outputView.printInputCommand();
            command = validate.validateCommand(inputView.readGameCommand());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readCommendValidate();
        }
        return command;
    }

}
