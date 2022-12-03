package bridge.domain;

import bridge.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    List<String> statementBridge;
    private static int nowIndex;
    String upState;
    String downState;
    public BridgeGame(List<String> statementBridge) {
        this.statementBridge= statementBridge;
        this.upState="";
        this.downState="";
    }



    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving) {

        if(!moveCheck(moving, statementBridge)){

            retry();
        }

        return
    }

    private boolean moveCheck(String moving, List<String> statementBridge) {
        if (moving.equals(statementBridge.get(nowIndex))) {
            setRightMoving(moving);
            painting(upState,downState);
            return true;
        }
        setWrongMoving(moving);
        painting(upState,downState);
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


    private void painting(String upState, String downState) {
        OutputView outputView= new OutputView();
        outputView.printMap(upState.chars().boxed().map(Character::toString).collect(Collectors.joining(" | ", "[ ", " ]")));
        outputView.printMap(downState.chars().boxed().map(Character::toString).collect(Collectors.joining(" | ", "[ ", " ]")));
        nowIndex++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        initInfo();
        return false;
    }

    private void initInfo() {
        upState="";
        downState="";
        nowIndex=0;
    }
}
