package bridge.domain.constant;

import java.util.Arrays;

public enum PanelDirections {
    DOWN("D", 0),
    UP("U", 1);

    private final String symbol;
    private final int key;

    private PanelDirections(String symbol, int key) {
        this.symbol = symbol;
        this.key = key;
    }

    public static String findSymbolByKey(int key) {
        return Arrays.stream(PanelDirections.values())
                .filter(direction -> key == direction.key)
                .findAny()
                .orElseThrow()
                .getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getKey() {
        return key;
    }
}
