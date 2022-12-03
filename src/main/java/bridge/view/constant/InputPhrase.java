package bridge.view.constant;

public enum InputPhrase {
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: " + MoveOptions.UP.get()
            + ", 아래: " + MoveOptions.DOWN.get() + ")");

    private final String phrase;

    private InputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
