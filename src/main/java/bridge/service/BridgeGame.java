package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.domain.constant.PanelDirections;
import bridge.domain.constant.UserStatus;
import bridge.service.constant.ChoiceResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static class InstanceHolder {
        private static final BridgeGame INSTANCE = new BridgeGame();
    }

    public static BridgeGame getInstance() {
        return BridgeGame.InstanceHolder.INSTANCE;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(User user, Bridge bridge, String userGuess) {
        user.playRound();
        boolean canUserMove = bridge.checkPanel(user.getRound(), userGuess);
        if (canUserMove && bridge.isLastPanel(user.getRound())) {
            user.clearGame();
        }
        if (!canUserMove) {
            user.fail();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(User user) {
        user.retry();
    }

    public List<List<ChoiceResult>> makeResult(User user, Bridge bridge) {
        List<List<ChoiceResult>> result = new ArrayList<>();
        Arrays.stream(PanelDirections.values())
                .forEach(direction -> result.add(
                        makeSuccessResultOfLine(user.getRound(), bridge.getPanels(), direction.getSymbol())
                ));
        if (user.getStatus() == UserStatus.FAIL) {
            result.forEach(this::addFailResult);
        }
        return result;
    }

    private List<ChoiceResult> makeSuccessResultOfLine(int order, List<String> bridge, String line) {
        return bridge.stream().limit(order)
                .map(panel -> calculateResult(panel, line))
                .collect(Collectors.toList());

    }

    private ChoiceResult calculateResult(String panel, String line) {
        if (panel.equals(line)) {
            return ChoiceResult.CORRECT;
        }
        return ChoiceResult.EMPTY;
    }

    private void addFailResult(List<ChoiceResult> bridgeLine) {
        int lastPanelIndex = convertOrderToIndex(bridgeLine.size());
        if (bridgeLine.get(lastPanelIndex) == ChoiceResult.CORRECT) {
            bridgeLine.set(lastPanelIndex, ChoiceResult.EMPTY);
            return;
        }
        bridgeLine.set(lastPanelIndex, ChoiceResult.WRONG);
    }

    private int convertOrderToIndex(int order) {
        return order - 1;
    }
}
