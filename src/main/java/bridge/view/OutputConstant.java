package bridge.view;

public enum OutputConstant {

    SIZE_INPUT("다리의 길이를 입력해주세요."),
    MOVE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    COMMAND_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT_ANNOUNCE("\n최종 게임 결과"),
    GAME_RESULT("\n게임 성공 여부: "),
    GAME_COUNT("총 시도한 횟수: ");


    private String output;

    OutputConstant(String output) {
        this.output = output;
    }

    public String message() {
        return output;
    }
}
