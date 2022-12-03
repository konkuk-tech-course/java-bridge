package bridge.converter;

import java.util.Arrays;

public enum RestartConverter {
    Q("Q", false),
    R("R", true);

    private final String restart;
    private final boolean result;

    RestartConverter(String restart, boolean result) {
        this.restart = restart;
        this.result = result;
    }

    public static boolean result(String restart) {
        return Arrays.stream(RestartConverter.values())
                .filter(o -> o.restart.equals(restart))
                .map(o -> o.result)
                .findAny()
                .get();
    }

    public String getRestart() {
        return restart;
    }

    public boolean isResult() {
        return result;
    }
}
