package bridge.util;

public enum GamePhrase {

    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    CHOOSE_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RESTART_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_RESULT("최종 게임 결과"),
    GAME_FAILED("게임 성공 여부: 실패"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    TOTAL_ATTEMPT("총 시도한 횟수: ");

    private final String message;

    GamePhrase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
