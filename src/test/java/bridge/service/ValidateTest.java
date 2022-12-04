package bridge.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateTest {
    Validate validate = new Validate();

    @ParameterizedTest
    @ValueSource(strings = {"24", "-2", "a", "12345"})
    @DisplayName("잘못된 다리 사이즈 입력이 들어왔을 때")
    void validateSizeException(String size) {
        Assertions.assertThatThrownBy(()->{
            validate.validateSize(size);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "w", "e", "a", "4"})
    @DisplayName("잘못된 움직임이 들어올 때")
    void validateMoveException(String move) {
        Assertions.assertThatThrownBy(()-> {
            validate.validateMove(move);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"m", "u", "e", "w", "q"})
    @DisplayName("잘못된 종료 분기 입력이 들어올 때")
    void validateCommandException(String command) {
        Assertions.assertThatThrownBy(()->{
            validate.validateCommand(command);
        }).isInstanceOf(IllegalArgumentException.class);
    }



}