package bridge.domain;

import bridge.util.ExceptionCode;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final int size;

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
        validate();
    }

    private void validate() {
        if(size > 20 || size <3) {
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
