package bridge.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> playBridge;
    private Judge judge;
    private final int GOAL;
    private int step;
    private boolean isGoal;
    private boolean isFail;

    public BridgeGame(List<String> answerBridge) {
        this.playBridge = new ArrayList<>();
        this.judge = new Judge(answerBridge);
        this.GOAL = answerBridge.size();
        this.isGoal = false;
        this.isFail = false;
        this.step = 0;
    }

    public List<String> getPlayBridge() {
        return playBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move) {
        playBridge.add(move);
        if (judge.checkStep(step, move)) {
            step++;
            checkGoal();
            return true;
        }
        isFail = true;
        return false;
    }

    private void checkGoal() {
        if (step==GOAL) {
            isGoal = true;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isGoal() {
        return isGoal;
    }

    public boolean isFail() {
        return isFail;
    }
}
