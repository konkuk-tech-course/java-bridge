package bridge.controller;

import bridge.service.ValidateSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {


    InputView inputView;
    OutputView outputView;
    ValidateSize validateSize = new ValidateSize();

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validateSize = validateSize;
    }

    public void start(){
        int size = readBridgeValidate();


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
