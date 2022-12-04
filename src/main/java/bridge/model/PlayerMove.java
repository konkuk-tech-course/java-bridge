package bridge.model;// @ author ninaaano

import java.util.Arrays;

import static bridge.model.Direction.DOWN;
import static bridge.model.Direction.UP;
import static bridge.model.MoveResult.FAIL;
import static bridge.model.MoveResult.SUCCESS;


/**
 *  - [x] getPlayerMove : 방향과 결과 반환
 */
public enum PlayerMove {
    UP_SUCCESS(UP, SUCCESS),
    UP_FAIL(UP, FAIL),
    DOWN_SUCCESS(DOWN, SUCCESS),
    DOWN_FAIL(DOWN, FAIL);

    private Direction direction;
    private MoveResult moveResult;

    PlayerMove(Direction direction, MoveResult moveResult) {
        this.direction = direction;
        this.moveResult = moveResult;
    }

    public PlayerMove getPlayerMove(Direction direction, MoveResult moveResult) {
        return Arrays.stream(PlayerMove.values())
                .filter(resultMove -> resultMove.direction == direction)
                .filter(resultMove -> resultMove.moveResult == moveResult)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));
    }
}

