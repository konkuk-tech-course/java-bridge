package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private BridgeLength length;
    private List<String> panels;

    public Bridge(BridgeLength length, List<String> panels) {
        this.length = length;
        this.panels = panels;
    }

    public int getLength() {
        return length.getLength();
    }

    public List<String> getPanels() {
        return Collections.unmodifiableList(panels);
    }
}
