package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Painting;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean gameResult) {
        System.out.println("\n최종 게임 결과");
        Painting.paint(bridgeGame.getUpState(), bridgeGame.getDownState());
        System.out.println("\n게임 성공 여부: " + ConvertResult.convert(gameResult));
        System.out.println("총 시도한 횟수: " + bridgeGame.getGameCount());
    }



    public void printException(String message) {
        System.out.println(message);
    }

    public void printInputSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

}
