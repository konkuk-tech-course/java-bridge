package bridge;

import static bridge.InputView.readGameCommand;
import static bridge.InputView.readMoving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameController {
    public static List<String> initializeBridge(Integer bridgeSize) {
        OutputView.String("다리 건너기 게임을 시작합니다.");
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public static Integer repeatReadBridgeSize() {
        while (true) {
            try {
                OutputView.String("다리의 길이를 입력해주세요.");
                Integer bridgeSize = InputView.readBridgeSize();
                return bridgeSize;
            } catch (NumberFormatException e) {
                OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    public static String repeatReadMoving() {
        while (true) {
            try {
                String input = readMoving();
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 유효한 값을 입력해주세요. (위: U, 아래: D)");
            }
        }
    }

    public static Boolean repeatAskRestart() {
        while (true) {
            try {
                OutputView.String("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                return readGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.String("[ERROR] 유효한 값을 입력해주세요. (재시도: R, 종료: Q)");
            }
        }

    }

    public static void print(String str) {
        OutputView.String(str);
    }

    public static void printMap(List<String> playerMap, List<String> bridgeInfo) {
        OutputView.printMap(makeMap(playerMap, bridgeInfo));
    }

    public static List<List<String>> makeMap(List<String> playerMap, List<String> bridgeInfo) {
        List<String> upperMap = new ArrayList<>();
        List<String> lowerMap = new ArrayList<>();
        for (Integer i=0; i < playerMap.size(); i++) {
            if (playerMap.get(i).equals(bridgeInfo.get(i))) {
                if (playerMap.get(i).equals("U")) {
                    upperMap.add(" O ");
                    lowerMap.add("   ");
                }
                if (playerMap.get(i).equals("D")) {
                    upperMap.add("   ");
                    lowerMap.add(" O ");
                }
            }
            if (!playerMap.get(i).equals(bridgeInfo.get(i))) {
                if (playerMap.get(i).equals("U")) {
                    upperMap.add(" X ");
                    lowerMap.add("   ");
                }
                if (playerMap.get(i).equals("D")) {
                    upperMap.add("   ");
                    lowerMap.add(" X ");
                }
            }
        }
        List<List<String>> result = new ArrayList<>(Arrays.asList(upperMap, lowerMap));
        return result;
    }

    public static void printResult(List<List<String>> map, Boolean success, Integer tryCount) {
        if (success) {
            OutputView.printResult(map, "성공", tryCount);
        }
        if (!success) {
            OutputView.printResult(map, "실패", tryCount);
        }
    }
}
