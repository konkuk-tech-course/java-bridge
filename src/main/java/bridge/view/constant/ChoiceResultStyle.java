package bridge.view.constant;

import bridge.domain.constant.PanelDirections;
import bridge.service.constant.ChoiceResult;

import java.util.Arrays;

public enum ChoiceResultStyle {
    CORRECT("O", ChoiceResult.CORRECT),
    WRONG("X", ChoiceResult.WRONG),
    EMPTY(" ", ChoiceResult.EMPTY);

    private final String style;
    private final ChoiceResult choiceResult;

    private ChoiceResultStyle(String style, ChoiceResult choiceResult) {
        this.style = style;
        this.choiceResult = choiceResult;
    }

    public static String findStyleByChoiceResult(ChoiceResult choiceResult) {
        return Arrays.stream(ChoiceResultStyle.values())
                .filter(choiceResultStyle -> choiceResult == choiceResultStyle.choiceResult)
                .findAny()
                .orElseThrow()
                .getStyle();
    }

    public String getStyle() {
        return style;
    }

    public ChoiceResult getChoiceResult() {
        return choiceResult;
    }
}
