package bridge.constraints;

public enum MoveCode {
    UPSIGN(1),
    DOWNSIGN(0);
    private final Integer code;

    MoveCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
