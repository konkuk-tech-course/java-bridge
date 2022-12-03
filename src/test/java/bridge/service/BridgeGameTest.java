package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeLength;
import bridge.domain.User;
import bridge.service.constant.ChoiceResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    private static BridgeGame bridgeGame = BridgeGame.getInstance();
    private static Bridge bridge;
    private static User user;

    @BeforeAll
    static void beforeAll() {
        List<String> panels = List.of("U", "D", "U");
        bridge = new Bridge(new BridgeLength(3), panels);
    }

    @BeforeEach
    void beforeEach() {
        user = new User();
    }

    @Test
    void makeResultTest() {
        user.playRound();
        user.playRound();

        List<List<ChoiceResult>> result = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.EMPTY),
                List.of(ChoiceResult.EMPTY, ChoiceResult.CORRECT)
        );
        assertThat(bridgeGame.makeResult(user, bridge)).isEqualTo(result);
    }

    @Test
    void MakeResultTest_When_User_Fail() {
        user.playRound();
        user.playRound();
        user.fail();

        List<List<ChoiceResult>> result = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.WRONG),
                List.of(ChoiceResult.EMPTY, ChoiceResult.EMPTY)
        );
        assertThat(bridgeGame.makeResult(user, bridge)).isEqualTo(result);
    }

}
