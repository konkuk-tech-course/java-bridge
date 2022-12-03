package bridge.view.constant;

public enum ViewErrorMessage {
    EMPTY("값을 입력하지 않았습니다."),
    NOT_NUMBER("숫자만 입력해주세요.");

    private final String message;

    private ViewErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
