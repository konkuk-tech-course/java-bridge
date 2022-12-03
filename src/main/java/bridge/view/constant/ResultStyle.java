package bridge.view.constant;

public enum ResultStyle {
    SUCCESS("성공"),
    FAIL("실패");

    private final String style;

    private ResultStyle(String style) {
        this.style = style;
    }

    public static String findStyle(boolean isGameClear) {
        if (isGameClear) {
            return SUCCESS.style;
        }
        return FAIL.style;
    }

    public String get() {
        return style;
    }
}
