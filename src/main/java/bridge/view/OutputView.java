package bridge.view;

import bridge.model.MoveResult;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_END_MESSAGE = "최종 게임 결과\n";
    private static final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: {0}";
    private static final String GAME_TRY_COUNT = "총 시도한 횟수: {0}";
    private static final String GAME_OUTPUT_MESSAGE = "[ + {0} + ]";
    private static final String GAME_DELIMITER_MESSAGE = " | ";
    private List<List<String>> path;


    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> path) {
        path.forEach(this::getResultMessage);
    }

    private String getResultMessage(List<String> moveResults) {
        return format(GAME_OUTPUT_MESSAGE,moveResults.stream()
                .map(i-> MoveResult.getCommand())
                .collect(Collectors.joining(GAME_DELIMITER_MESSAGE)));

    }

    /**
     * private String getResultMessage(List<MoveResult> moveResults) {
     *         return format(MAP_MESSAGE_FORMAT, moveResults.stream()
     *                 .map(MoveResult::getCommand)
     *                 .collect(Collectors.joining(MAP_MESSAGE_DELIMITER))
     *         );
     *     }
     */

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> path,int count) {
        System.out.println(GAME_END_MESSAGE);
        printMap(path);
        System.out.printf(GAME_SUCCESS_OR_NOT,GAME_TRY_COUNT, path, count);

    }
}
