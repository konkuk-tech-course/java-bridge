package bridge.view.constant;

public enum ViewErrorMessage {
    EMPTY("값을 입력하지 않았습니다."),
    NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_MOVE_OPTION(MoveOptions.UP.get() + "(위), "
            + MoveOptions.DOWN.get() + "(아래) 중 하나만 입력해주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    private ViewErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message;
    }
}
