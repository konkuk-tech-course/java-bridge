package bridge.view.constant;

import bridge.service.constant.ChoiceResult;

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

    public String getStyle() {
        return style;
    }

    public ChoiceResult getChoiceResult() {
        return choiceResult;
    }
}
