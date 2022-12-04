package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeResultMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void playTheGame() {
        // 처음 메세지 출력
        outputView.printStartMessage();
        // 다리 길이 입력 받기
        int bridgeSize = inputView.readBridgeSize();
        //브릿지 생성
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

//        BridgeResultMaker bridgeResultMaker = new BridgeResultMaker(bridge);

        // 이동할 칸 받기 + 결과 출력 하기
        String moveResult = inputView.readMoving();
        outputView.printMap();
        // 이동한 갯수 == 다리 크기 시 최종 결과 출력
        outputView.printResult();

        // 떨어 졌을때 입력 받기
        inputView.readGameCommand();
        // Q입력시 최종 게임 결과 출력하기
        // R 입력 시, 위치 처음으로 이동해서 다시 게임 실행

        // 최종 게임 결과 반환
        outputView.printResult();
    }
}
