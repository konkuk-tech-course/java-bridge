package bridge.view.constant;

public enum ValidationRegex {
    EMPTY("^$"),
    ONLY_NUMBER("^[0-9]+$"),
    MOVE_OPTION("^[UD]+$");

    private final String regex;

    private ValidationRegex(String regex) {
        this.regex = regex;
    }

    public String get() {
        return regex;
    }
}
