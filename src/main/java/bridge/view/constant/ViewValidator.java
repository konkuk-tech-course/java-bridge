package bridge.view.constant;

import java.util.regex.Pattern;

public class ViewValidator {
    public static void validateNumberInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }
        if (hasNonNumericCharacter(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.NOT_NUMBER.get());
        }
    }

    private static boolean isEmpty(String input) {
        return Pattern.matches(ValidationRegex.EMPTY.get(), input);
    }

    private static boolean hasNonNumericCharacter(String input) {
        return !Pattern.matches(ValidationRegex.ONLY_NUMBER.get(), input);
    }

    public static void validateMoveOptionInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }
        if (!isValidOption(input, ValidationRegex.MOVE_OPTION.get())) {
            throw new IllegalArgumentException(ViewErrorMessage.INVALID_MOVE_OPTION.get());
        }
    }

    public static void validateRetryOptionInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }
        if (!isValidOption(input, ValidationRegex.RETRY_OPTION.get())) {
            throw new IllegalArgumentException(ViewErrorMessage.INVALID_RETRY_OPTION.get());
        }
    }

    private static boolean isValidOption(String input, String optionRegex) {
        return Pattern.matches(optionRegex, input);
    }
}
