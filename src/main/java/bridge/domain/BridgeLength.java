package bridge.domain;

import bridge.domain.constant.BridgeProperties;
import bridge.domain.constant.DomainErrorMessage;

public class BridgeLength {
    private int length;

    public BridgeLength(int length) {
        validate(length);
        this.length = length;
    }

    private void validate(int length) {
        if (isInvalidRange(length)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_RANGE_LENGTH.get());
        }
    }

    private boolean isInvalidRange(int length) {
        return length < BridgeProperties.MIN_LENGTH.get()
                || length > BridgeProperties.MAX_LENGTH.get();
    }

    public int getLength() {
        return length;
    }
}
