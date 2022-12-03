package bridge.domain;

import bridge.domain.constant.PanelDirections;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private BridgeLength length;
    private List<String> panels;

    public Bridge(BridgeLength length, List<String> panels) {
        this.length = length;
        this.panels = panels;
    }

    public boolean checkPanel(int order, String panelSymbol) {
        int panelIndex = convertOrderToIndex(order);
        return panels.get(panelIndex).equals(panelSymbol);
    }

    private int convertOrderToIndex(int order) {
        return order - 1;
    }

    public boolean isLastPanel(int order) {
        return order == length.getLength();
    }

    public int getLength() {
        return length.getLength();
    }

    public List<String> getPanels() {
        return Collections.unmodifiableList(panels);
    }
}
