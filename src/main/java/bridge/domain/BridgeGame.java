package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> statementBridge;

    private static int nowIndex=-1;
    Painting painting;
    String upState;
    String downState;
    static int gameCount=1;
    public BridgeGame(List<String> statementBridge) {
        this.statementBridge= statementBridge;
        this.upState="";
        this.downState="";
        this.painting=new Painting();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {
        nowIndex++;
        if(!moveCheck(moving, statementBridge)){
            return false;
        }
        return true;
    }

    private boolean moveCheck(String moving, List<String> statementBridge) {
        if (moving.equals(statementBridge.get(nowIndex))) {
            setRightMoving(moving);
            painting.paint(upState,downState);
            return true;
        }
        setWrongMoving(moving);
        painting.paint(upState,downState);
        return false;
    }

    private void setWrongMoving(String moving) {
        if(moving.equals("U")){
            upState+="X";
            downState+=" ";
        }
        if(moving.equals("D")){
            upState+=" ";
            downState+="X";
        }
    }

    private void setRightMoving(String moving) {
            if(moving.equals("U")){
                upState+="O";
                downState+=" ";
            }
            if(moving.equals("D")){
                upState+=" ";
                downState+="O";
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
        upState="";
        downState="";
        nowIndex=-1;
    }

    public int getGameCount() {
        return gameCount;
    }

    public static int getNowIndex() {
        return nowIndex;
    }
}
