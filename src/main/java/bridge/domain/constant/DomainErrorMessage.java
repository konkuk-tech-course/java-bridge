package bridge.domain.constant;

public enum DomainErrorMessage {
    INVALID_RANGE_LENGTH("다리의 길이는 " + BridgeProperties.MIN_LENGTH.get() + "이상 "
            + BridgeProperties.MAX_LENGTH.get() + "이하만 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    private DomainErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message;
    }
}
