package bridge.domain;

import bridge.LocationState;
import bridge.view.Painting;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private static int nowIndex = GameState.INIT_INDEX.getIndex();
    private final List<String> bridgeStatement;
    private Painting painting;
    private String upState;
    private String downState;
    private int gameCount;

    public BridgeGame(List<String> bridgeStatement) {
        this.bridgeStatement = bridgeStatement;
        this.gameCount=1;
        this.upState = "";
        this.downState = "";
        this.painting = new Painting();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving) {
        nowIndex++;
        return moving;
    }

    public boolean moveCheck(String moving) {
        if (isRightMoving(moving)) {
            setRightMovingState(moving);
            painting.paint(upState, downState);
            return true;
        }
        setWrongMovingState(moving);
        painting.paint(upState, downState);
        return false;
    }

    private boolean isRightMoving(String moving) {
        if (moving.equals(bridgeStatement.get(nowIndex))) {
            return true;
        }
        return false;
    }

    private void setWrongMovingState(String moving) {
        if (moving.equals(LocationState.UP.getState())) {
            upState += GameState.WRONG.getState();
            downState += GameState.EMPTY.getState();
        }
        if (moving.equals(LocationState.DOWN.getState())) {
            upState += GameState.EMPTY.getState();
            downState += GameState.WRONG.getState();
        }
    }

    private void setRightMovingState(String moving) {
        if (moving.equals(LocationState.UP.getState())) {
            upState += GameState.RIGHT.getState();
            downState += GameState.EMPTY.getState();
        }
        if (moving.equals(LocationState.DOWN.getState())) {
            upState += GameState.EMPTY.getState();
            downState += GameState.RIGHT.getState();
        }
    }


    public String getUpState() {
        return upState;
    }

    public String getDownState() {
        return downState;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        initInfo();
        gameCount++;
        return false;
    }

    private void initInfo() {
        upState = GameState.INIT_STATE.getState();
        downState = GameState.INIT_STATE.getState();
        nowIndex = GameState.INIT_INDEX.getIndex();
    }

    public int getGameCount() {
        return gameCount;
    }

    public static int getNowIndex() {
        return nowIndex;
    }
}
