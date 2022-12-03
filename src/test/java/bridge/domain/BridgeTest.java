package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {
    static Bridge bridge;

    @BeforeEach
    void beforeEach() {
        List<String> panels = List.of("U", "D", "U");
        bridge = new Bridge(new BridgeLength(3), panels);
    }

    @Test
    void When_InputSymbolEqualWithPanel_Expect_True() {
        assertThat(bridge.checkPanel(1, "U")).isTrue();
    }

    @Test
    void When_InputSymbolDoesNotEqualWithPanel_Expect_False() {
        assertThat(bridge.checkPanel(1, "D")).isFalse();
    }

    @Test
    void When_LastOrderOfPanel_Expect_True() {
        assertThat(bridge.isLastPanel(3)).isTrue();
    }

    @Test
    void When_BeforeLastOrderOfPanel_Expect_False() {
        assertThat(bridge.isLastPanel(2)).isFalse();
    }
}
