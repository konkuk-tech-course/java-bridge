package bridge.domain.constant;

public enum PanelDirections {
    DOWN("D", 0),
    UP("U", 1);

    private final String symbol;
    private final int key;

    private PanelDirections(String symbol, int key) {
        this.symbol = symbol;
        this.key = key;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getKey() {
        return key;
    }
}
