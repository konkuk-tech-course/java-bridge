package bridge.util;

import java.util.Arrays;

import static bridge.util.ExceptionCode.WRONG_NUMBER;

public enum BridgeConverter {
    U(0, "U"),
    D(1, "D");

    private final int number;
    private final String direction;

    BridgeConverter(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public int getNumber() {
        return number;
    }

    public String getDirection() {
        return direction;
    }

    public static String direction(int number) {
        return Arrays.stream(BridgeConverter.values())
                .filter(o -> o.number == number)
                .map(o -> o.direction)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_NUMBER.getMessage()));
    }
}
