package bridge.view;

import bridge.domain.BridgeGame;

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
        System.out.println(OutputConstant.RESULT_ANNOUNCE.message());
        Painting.paint(bridgeGame.getUpState(), bridgeGame.getDownState());
        System.out.println(OutputConstant.GAME_RESULT.message() + ConvertResult.convert(gameResult));
        System.out.println(OutputConstant.GAME_COUNT.message() + bridgeGame.getGameCount());
    }



    public void printException(String message) {
        System.out.println(message);
    }

    public void printInputSize() {
        System.out.println(OutputConstant.SIZE_INPUT.message());
    }

    public void printInputMove() {
        System.out.println(OutputConstant.MOVE_INPUT.message());
    }

    public void printInputCommand() {
        System.out.println(OutputConstant.COMMAND_INPUT.message());
    }

}
