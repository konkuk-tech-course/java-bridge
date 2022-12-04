package bridge.view;

public enum GameResultConstant {

    SUCCESS("성공"),
    FAIL("실패");

    private String result;

    GameResultConstant(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
