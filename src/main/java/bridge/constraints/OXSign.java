package bridge.constraints;

public enum OXSign {

    SUCCESS_SIGN(" O "),
    FAIL_SIGN(" X ");

    private final String sign;

    OXSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
