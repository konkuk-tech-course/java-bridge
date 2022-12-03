package bridge.domain;

import bridge.constant.ExceptionCode;

import java.util.List;

public class Bridge {

    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 3;
    private final List<String> bridge;
    private final int size;

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
        validate();
    }

    private void validate() {
        if(size > MAX_SIZE || size <MIN_SIZE) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_SIZE_RANGE.getMessage());
        }
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return size;
    }
}
