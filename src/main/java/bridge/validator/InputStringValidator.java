package bridge.validator;

import bridge.util.ExceptionCode;

import static bridge.util.Constant.*;

public class InputStringValidator {
    public void validateDirection(String direction) {
        if(!(direction.equals(U.getValue()) || direction.equals(D.getValue()))) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_INPUT_DIRECTION.getMessage());
        }
    }

    public void validateRestart(String restart) {
        if(!(restart.equals(Q.getValue()) || restart.equals(R.getValue()))) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_QUIT_ANSWER.getMessage());
        }
    }
}
