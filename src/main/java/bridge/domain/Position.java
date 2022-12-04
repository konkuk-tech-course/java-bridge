package bridge.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Position {

    private static final Map<Integer, Position> POSITIONS = new HashMap<>();

    static {
        IntStream.range(0, 20)
                .forEach(i -> POSITIONS.put(i, new Position(i)));
    }
    private final int value;
    public Position(int value) {
        this.value = value;
    }

    public Position of(int key) {
        validatekey(key);
        return POSITIONS.get(key);
    }

    private void validatekey(int key) {
        if (!POSITIONS.containsKey(key)) {
            throw new IllegalArgumentException("[ERROR] 플레이어 위치값은 0에서 19까지만 가능합니다");
        }
    }

    public int getValue() {
        return this.value;
    }

    public Position increase() {
        validatekey(value + 1);
        return POSITIONS.get(value + 1);
    }

    public Position reset() {
        return POSITIONS.get(0);
    }

}
