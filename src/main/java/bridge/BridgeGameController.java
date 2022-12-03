package bridge;

import java.util.List;

public class BridgeGameController {
    public static List<String> initializeBridge(Integer bridgeSize) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public static Integer repeatReadBridgeSize() {
        while (true) {
            try {
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
