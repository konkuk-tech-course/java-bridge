package bridge.view;

import bridge.validator.InputStringValidator;
import bridge.validator.InputSizeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputSizeValidator inputSizeValidator;
    private final InputStringValidator inputStringValidator;
    public InputView() {
        inputSizeValidator = new InputSizeValidator();
        inputStringValidator = new InputStringValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        inputSizeValidator.validateParseSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        inputStringValidator.validateDirection(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        inputStringValidator.validateRestart(input);
        return input;
    }
}
