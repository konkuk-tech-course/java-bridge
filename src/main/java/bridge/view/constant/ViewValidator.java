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
}
