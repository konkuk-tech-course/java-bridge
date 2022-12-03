package bridge.util;

public enum ExceptionCode {
    WRONG_NUMBER("wrong Number"),
    INVALID_QUIT_ANSWER("Q(게임 종료)나 R(재시작) 중 하나만 입력해주세요");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
