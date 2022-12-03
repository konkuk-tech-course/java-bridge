package bridge.util;

public enum Constant {

    GAME_RESULT("최종 게임 결과"),
    GAME_FAILED("게임 성공 여부 : 실패"),
    GAME_SUCCESS("게임 성공 여부 : 성공"),
    TOTAL_ATTEMPT("총 시도 횟수 : ");

    private final String message;

    Constant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
