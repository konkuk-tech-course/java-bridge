package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.GameStop;
import bridge.service.Validate;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class BridgeController {

    private InputView inputView;
    private OutputView outputView;
    private GameStop gameStop;
    private Validate validate;
    private BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validate = new Validate();
        this.gameStop =new GameStop();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start(){
        int size = readBridgeValidate();
        List<String> statementBridge = bridgeMaker.makeBridge(size);
        moveStart(statementBridge,size);
    }

    private void moveStart(List<String> statementBridge, int size) {
        BridgeGame bridgeGame = new BridgeGame(statementBridge);
        boolean retry = true;
        while(keepMoving(size, bridgeGame, retry)){
            String moving = bridgeGame.move(readMovingValidate());
            if(!bridgeGame.moveCheck(moving)){
                retry = gameStop.isRetry(readCommandValidate(), bridgeGame);
            }
        }
        outputView.printResult(setResultList(bridgeGame), bridgeGame.getGameCount(), gameStop.getGameResult());
    }

    private List<String> setResultList(BridgeGame bridgeGame) {
        return Arrays.asList(bridgeGame.getUpState(), bridgeGame.getDownState());
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

    private String readCommandValidate(){
        String command=null;
        try{
            outputView.printInputCommand();
            command = validate.validateCommand(inputView.readGameCommand());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readCommandValidate();
        }
        return command;
    }

}
