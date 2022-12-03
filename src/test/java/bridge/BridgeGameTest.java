package bridge;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @Test
    void moveTest() {
        BridgeGame.clear();
        boolean t = BridgeGame.move("U",true);

        assertThat(t).isTrue();
        boolean t1 = BridgeGame.bridges.get(0).contains(" O ");
        System.out.println(BridgeGame.bridges);
        assertThat(t1).isTrue();
    }
}
