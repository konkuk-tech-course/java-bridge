package bridge;

import static bridge.BridgeGameController.repeatAskRestart;
import static bridge.BridgeGameController.repeatReadMoving;
import static bridge.InputView.readGameCommand;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridgeInfo = BridgeGameController.initializeBridge(BridgeGameController.repeatReadBridgeSize());
    private final Integer bridgeSize = bridgeInfo.size();
    private Boolean success = false;
    private Integer tryCount = 0;
    private Integer playerLocation = 0;
    private Boolean keepPlay = true;
    public BridgeGame() {
        play();
    }

    public void play() {
        this.success = false;
        this.playerLocation = 0;
        this.keepPlay = true;
        while (keepPlay) {
            Boolean result = repeatProcess();
            this.tryCount++;
            retry(result);
        }
    }

    public Boolean repeatProcess() {
        for (Integer I = 0; I < bridgeSize; I++) {
            BridgeGameController.print("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String input = repeatReadMoving();
            Boolean result = BridgeGameController.analyzeMoving(input);
            if (result) {
                move();
            }
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
    public void move() {
        playerLocation++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Boolean result) {
        if (result) {
            this.success = true;
            keepPlay = repeatAskRestart();
        }
        if (!result) {
            this.success = false;
            keepPlay = repeatAskRestart();
        }
    }
}
