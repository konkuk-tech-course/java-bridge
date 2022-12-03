package bridge;

import static bridge.BridgeGameController.printMap;
import static bridge.BridgeGameController.printResult;
import static bridge.BridgeGameController.repeatAskRestart;
import static bridge.BridgeGameController.repeatReadMoving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final List<String> bridgeInfo = BridgeGameController
            .initializeBridge(BridgeGameController.repeatReadBridgeSize());
    private final Integer bridgeSize = bridgeInfo.size();
    private Boolean success = false;
    private Integer tryCount = 0;
    private static List<String> playerMap = new ArrayList<>();
    private Boolean keepPlay = true;
    public BridgeGame() {
        play();
    }

    public void play() {
        System.out.println(bridgeInfo.toString());
        this.success = false;
        this.keepPlay = true;
        repeatGame();
        printResult(new BridgeMap(playerMap, bridgeInfo).showMap(), success, tryCount);
    }

    public void repeatGame() {
        while (keepPlay) {
            this.playerMap.clear();
            Boolean result = repeatProcess();
            this.tryCount++;
            if (result) {
                this.success = true;
                break;
            }
            retry();
        }
    }

    public Boolean repeatProcess() {
        for (Integer index = 0; index < bridgeSize; index++) {
            BridgeGameController.print("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = repeatReadMoving();
            Boolean result = new BridgeAnalyze(input, index, bridgeInfo).analyze();
            move(input);
            printMap(playerMap, bridgeInfo);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        this.playerMap.add(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.keepPlay = repeatAskRestart();
    }
}
