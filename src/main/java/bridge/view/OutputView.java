package bridge.view;

import bridge.service.constant.ChoiceResult;
import bridge.view.constant.BridgeStyle;
import bridge.view.constant.ChoiceResultStyle;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputView.InstanceHolder.INSTANCE;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<ChoiceResult>> bridge) {
        bridge.stream()
                .map(this::styleBridgePanels)
                .map(this::styleBridge)
                .forEach(System.out::println);
    }

    private List<String> styleBridgePanels(List<ChoiceResult> bridgeLine) {
        return bridgeLine.stream()
                .map(ChoiceResultStyle::findStyleByChoiceResult)
                .collect(Collectors.toList());
    }

    private String styleBridge(List<String> bridgeLine) {
        return bridgeLine.stream().collect(Collectors.joining(
                BridgeStyle.DELIMITER.get(),
                BridgeStyle.START.get(),
                BridgeStyle.END.get()
        ));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
