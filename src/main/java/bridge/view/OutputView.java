package bridge.view;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.util.GamePhrase.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void startGame() {
        System.out.println(START_GAME.getMessage());
    }
    public void bridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE.getMessage());
    }

    public void gameStartPhrases() {
        startGame();
        bridgeSize();
    }

    public void chooseDirection() {
        System.out.println(CHOOSE_DIRECTION.getMessage());
    }
    public void inputRestartGame() {
        System.out.println(INPUT_RESTART_GAME.getMessage());
    }

    public void printMap(List<List<String>> bridges) {
        String upBridge = convertBridge(bridges.get(0));
        String downBridge = convertBridge(bridges.get(1));

        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private String convertBridge(List<String> bridge) {
        return bridge.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("|","[","]"));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridges, boolean result) {
        System.out.println(GAME_RESULT.getMessage());
        printMap(bridges);
        if(!result) {
            System.out.println(GAME_FAILED.getMessage());
        }
        if(result){
            System.out.println(GAME_SUCCESS.getMessage());
        }
    }
    public void printAttempt(int attempt) {
        System.out.println(TOTAL_ATTEMPT.getMessage()+attempt);
    }
}
