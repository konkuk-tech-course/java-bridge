package bridge.view.constant;

public enum BridgeStyle {
    START("[ "),
    END(" ]"),
    DELIMITER(" | ");

    private final String style;

    private BridgeStyle(String style) {
        this.style = style;
    }

    public String get() {
        return style;
    }
}
