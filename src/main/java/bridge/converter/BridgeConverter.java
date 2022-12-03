package bridge.converter;

import java.util.Arrays;

import static bridge.constant.ExceptionCode.WRONG_NUMBER;

public enum BridgeConverter {
    U(1, "U"),
    D(0, "D");

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
