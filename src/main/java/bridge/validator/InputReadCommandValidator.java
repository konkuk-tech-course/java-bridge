package bridge.validator;

import bridge.constant.ExceptionCode;

import static bridge.constant.Constant.Q;
import static bridge.constant.Constant.R;

public class InputReadCommandValidator {
    public void validateRestart(String restart) {
        if(!(restart.equals(Q.getValue()) || restart.equals(R.getValue()))) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_QUIT_ANSWER.getMessage());
        }
    }
}
