package bridge;

import bridge.domain.Bridge;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {


    @Test
    void validateRangeTest() {
        List<String> list = List.of("U", "D","U");
        assertThatThrownBy(() -> new Bridge(list, 2)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("3에서 20사이로 입력해주세요");
        assertThatThrownBy(() -> new Bridge(list, 21)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("3에서 20사이로 입력해주세요");
    }

    @Test
    void validateRangeTest2() {
        List<String> list = List.of("U", "D","U");
        Bridge b = new Bridge(list, 4);
        assertThat(b.getSize()).isEqualTo(4);
    }
}
