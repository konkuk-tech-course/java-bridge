package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import bridge.LocationState;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    List<String> bridgeStatement = Arrays.asList("U", "U", "D");
    BridgeGame bridgeGame = new BridgeGame(bridgeStatement);

    @Test
    void move() {
        int nowIndex = bridgeGame.getNowIndex();
        bridgeGame.move(LocationState.UP.getState());
        int afterIndex = bridgeGame.getNowIndex();
        Assertions.assertThat(nowIndex).isLessThan(afterIndex);
    }

    @Test
    void moveCheck() {
        String moving1 = LocationState.UP.getState();
        int nowIndex = 0;
        Assertions.assertThat(moving1.equals(bridgeStatement.get(nowIndex))).isTrue();
        String moving2 = LocationState.DOWN.getState();
        nowIndex++;
        Assertions.assertThat(moving2.equals(bridgeStatement.get(nowIndex))).isFalse();
    }


}