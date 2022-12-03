package bridge.service;

public enum ExceptionMessage {


    ERROR_SIZE_NUMBER("[ERROR] 다리의 사이즈는 숫자여야 합니다."),
    ERROR_SIZE_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_MOVE_INPUT("[ERROR] 움직임으로는 U, D의 커맨드만 입력받을 수 있습니다."),
    ERROR_COMMAND_INPUT("[ERROR] 게임 종료 재시작으로는 R,Q의 커맨드만 입력 가능합니다.");


    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
