package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeAnalyzeTest {
    @DisplayName("다리 건너기 성공 여부를 분석하는 메소드 테스트")
    @Test
    void analyzeTest1() {
        List<String> bridgeInfo = new ArrayList<>(Arrays.asList("U", "D", "D"));
        assertThat(new BridgeAnalyze("U", 0, bridgeInfo).analyze()).isEqualTo(true);
    }

    @DisplayName("다리 건너기 성공 여부를 분석하는 메소드 테스트")
    @Test
    void analyzeTest2() {
        List<String> bridgeInfo = new ArrayList<>(Arrays.asList("U", "D", "D"));
        assertThat(new BridgeAnalyze("D", 0, bridgeInfo).analyze()).isEqualTo(false);
    }
}