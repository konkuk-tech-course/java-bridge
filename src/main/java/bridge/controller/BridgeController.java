package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.ValidateSize;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {


    InputView inputView;
    OutputView outputView;
    ValidateSize validateSize;
    BridgeMaker bridgeMaker;
    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validateSize = new ValidateSize();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start(){
        int size = readBridgeValidate();
        List<String> statementBridge = bridgeMaker.makeBridge(size);

    }



    private int readBridgeValidate(){
        int size=0;
        try{
            outputView.printInputSize();
            validateSize.validate(inputView.readBridgeSize());
        }catch(IllegalArgumentException e){
            outputView.printException(e.getMessage());
            return readBridgeValidate();
        }
        return size;
    }
}
