package bridge.constant;

public enum ExceptionCode {
    WRONG_NUMBER("wrong Number"),
    INVALID_QUIT_ANSWER("Q(게임 종료)나 R(재시작) 중 하나만 입력해주세요"),
    INVALID_INPUT_SIZE("숫자를 입력해주세요"),
    INVALID_INPUT_DIRECTION("U나 D를 입력해주세요"),
    INVALID_SIZE_RANGE("3에서 20사이로 입력해주세요");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

