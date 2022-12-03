package bridge.view.constant;

public enum OutputPhrase {
    GAME_START("다리 건너기 게임을 시작합니다."),
    RESULT_TITLE("최종 게임 결과"),
    RESULT("게임 성공 여부: %s"),
    ATTEMPT_COUNT("총 시도한 횟수: %d");

    private final String phrase;

    private OutputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
