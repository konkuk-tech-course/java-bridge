package bridge.constraints;

public enum OutputMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    FINAL_RESULT_MESSAGE("최종 게임 결과"),
    SUCCESS_MESSAGE("게임 성공 여부: 성공"),
    FAILURE_MESSAGE("게임 성공 여부: 실패"),
    TRY_COUNT_MESSAGE("총 시도한 횟수: "),
    LEFT_SQARE_BRACKET("["),
    RIGHT_SQARE_BRACKET("]"),
    BAR(" | ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
