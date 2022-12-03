package bridge.view.constant;

import java.util.regex.Pattern;

public class ViewValidator {
    public static boolean isEmpty(String input) {
        return Pattern.matches(ValidationRegex.EMPTY.get(), input);
    }

    public static boolean hasNonNumericCharacter(String input) {
        return !Pattern.matches(ValidationRegex.ONLY_NUMBER.get(), input);
    }
}
