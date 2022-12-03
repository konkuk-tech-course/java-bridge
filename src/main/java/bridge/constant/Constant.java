package bridge.constant;

public enum Constant {
    U("U"),
    D("D"),
    Q("Q"),
    R("R"),
    O(" O "),
    X(" X "),
    BLANK("   "),
    ERROR("[ERROR]");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
