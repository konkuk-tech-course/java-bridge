package bridge.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.constant.ViewValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ViewValidatorTest {
    private static final String ERROR_PREFIX = "[ERROR]";
    @Test
    void When_EmptyValueInput_Expect_IllegalArgumentException() {
        assertThatThrownBy(() -> ViewValidator.validateNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("값을 입력하지 않았습니다");
    }

    @Test
    void When_NonNumericValueInput_Expect_IllegalArgumentException() {
        assertThatThrownBy(() -> ViewValidator.validateNumberInput("1a3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("숫자만");
    }

    @Test
    void When_NumberInput_Expect_NoException() {
        assertThatCode(() -> ViewValidator.validateNumberInput("13"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "{index}) option input = {0}")
    @ValueSource(strings = { "UD", "1", "R", "u", "dsfe" })
    void When_InvalidMoveOption_Expect_IllegalArgumentException(String input) {
        assertThatThrownBy(() -> ViewValidator.validateMoveOptionInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX)
                .hasMessageContaining("U(위), D(아래)");
    }

    @ParameterizedTest(name = "{index}) option input = {0}")
    @ValueSource(strings = { "U", "D" })
    void When_ValidMoveOption_Expect_NoException(String input) {
        assertThatCode(() -> ViewValidator.validateMoveOptionInput(input))
                .doesNotThrowAnyException();
    }
}
