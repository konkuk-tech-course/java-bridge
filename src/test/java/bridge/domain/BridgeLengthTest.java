package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeLengthTest {
    @ParameterizedTest(name = "{index}) length input = {0}")
    @ValueSource(ints = { 3, 4 , 6, 10, 11, 15, 20 })
    void When_ValidRangeOfLength_Expect_NoException(int input) {
        BridgeLength length = new BridgeLength(input);
        assertThat(length.getLength()).isEqualTo(input);
    }

    @ParameterizedTest(name = "{index}) length input = {0}")
    @ValueSource(ints = { 0, 1, 2, 21, 25, 200 })
    void When_InvalidRangeOfLength_Expect_IllegalArgumentException(int input) {
        assertThatThrownBy(() -> new BridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("3이상 20이하");
    }
}
