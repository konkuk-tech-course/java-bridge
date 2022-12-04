package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constraints.InputMessage.*;
import static bridge.util.Utils.convertStringToInteger;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE.getMessage());
        String bridgeSizeInput = Console.readLine();
        return convertStringToInteger(bridgeSizeInput);
    }
    
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_DIRECTION_CHOOSING_MESSAGE.getMessage());
        String moveSign = Console.readLine();
        return moveSign;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_OR_QUIT_MESSAGE.getMessage());
        String command = Console.readLine();
        return command;
    }
}
