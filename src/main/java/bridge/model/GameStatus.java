package bridge.model;// @ author ninaaano


import java.util.Arrays;

import static bridge.model.Direction.DOWN;
import static bridge.model.Direction.UP;
import static bridge.model.MoveResult.FAIL;
import static bridge.model.MoveResult.SUCCESS;

/**
 * - [x] isDirection : 입력 방향과 같은 방향인지 확인
 * - [x] startGameCount : 게임 시도 횟수
 * --- + 추가된 사항
 * - [x] playGameCount : 게임 시도 횟수 증가
 * - [x] getAttempsGame : 게임 시도 횟수 반환
 * --- + 추가된 사항
 * - [] isFail
 * - [] getMoveResult
 */
public class GameStatus {

    private final Direction direction;
    private final MoveResult moveResult;

    private Integer count;

    private GameStatus(Integer count, Direction direction, MoveResult moveResult) {
        this.count = count;
        this.direction = direction;
        this.moveResult = moveResult;
    }

    public int startGameCount() {
        return 1;
    }

    public void playGameCount() {
        count++;
    }

    public Integer getAttempsGame() {
        return count;
    }

    public boolean isDirection(Direction direction) {
        return this.direction.isNotEqualsDirection(direction);
    }

    public boolean isFail() {
        return moveResult.isFail();
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }


}
