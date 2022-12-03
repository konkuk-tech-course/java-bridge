package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class BridgeMakerTest {
    private static MockedStatic<Randoms> mock;

    @BeforeEach
    void beforeEach() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 0, 1);
    }

    @AfterEach
    void afterEach() {
        mock.close();
    }

    @Test
    void makeBridgeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "U");
    }
}
