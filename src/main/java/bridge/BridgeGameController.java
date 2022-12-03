package bridge;

import java.util.List;

public class BridgeGameController {
    public static List<String> initializeBridge(Integer bridgeSize) {
        OutputView.String("다리 건너기 게임을 시작합니다.");
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public static void play() {
        
    }

    public static Integer repeatReadBridgeSize() {
        while (true) {
            try {
                OutputView.String("다리의 길이를 입력해주세요.");
                Integer bridgeSize = InputView.readBridgeSize();
                return bridgeSize;
            } catch (NumberFormatException e) {
                OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }
}
