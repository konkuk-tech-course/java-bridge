package bridge.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upCommand;
    private List<String> downCommand;
    private int moveCount;
    private int gameCount;

    public BridgeGame() {
        this.upCommand = new LinkedList<>();
        this.downCommand = new LinkedList<>();
        this.gameCount = 1;
        this.moveCount = 0;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(MoveResult moveResult) {
        if (moveResult.getCommand().equals(Direction.UP.getCommand())) {
            return addUpCount(moveResult);
        }
        return addDownCount(moveResult);
    }

    private List<List<String>> addDownCount(MoveResult moveResult) {
        downCommand.add(moveResult.getCommand());
        upCommand.add(" ");
        return List.of(upCommand, downCommand);
    }

    private List<List<String>> addUpCount(MoveResult moveResult) {
        upCommand.add(moveResult.getCommand());
        downCommand.add(" ");
        return List.of(upCommand, downCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upCommand.clear();
        downCommand.clear();
        gameCount++;
    }

    public int countMove() {
        return moveCount++;
    }

}
