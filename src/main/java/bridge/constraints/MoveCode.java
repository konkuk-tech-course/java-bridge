package bridge.constraints;

public enum MoveCode {
    UPSIGN(1, "U"),
    DOWNSIGN(0, "D");
    private final Integer integerCode;
    private final String stringCode;

    MoveCode(Integer integerCode, String stringCode) {
        this.integerCode = integerCode;
        this.stringCode = stringCode;
    }

    public Integer getIntegerCode() {
        return this.integerCode;
    }

    public String getStringCode() {
        return this.stringCode;
    }
}
