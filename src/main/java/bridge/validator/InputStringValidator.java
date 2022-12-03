package bridge.validator;

import bridge.util.ExceptionCode;

public class InputStringValidator {
    public void validateDirection(String direction) {
        if(!(direction.equals("U") || direction.equals("D"))) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_INPUT_DIRECTION.getMessage());
        }
    }

    public void validateRestart(String restart) {
        if(!(restart.equals("Q") || restart.equals("R"))) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_QUIT_ANSWER.getMessage());
        }
    }
}
