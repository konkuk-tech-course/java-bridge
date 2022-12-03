package bridge.validator;

import bridge.util.ExceptionCode;

import java.util.NoSuchElementException;

public class InputSizeValidator {

    public void validateParseSize(String input) {
        try{
            Integer.parseInt(input);
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_INPUT_SIZE.getMessage());
        }
    }
}
