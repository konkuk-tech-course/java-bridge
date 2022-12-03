package bridge;

import static java.lang.Integer.parseInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static Integer readBridgeSize() {
        Integer input = parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        if (input < 3 | input > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        if (input.equals("U") | input.equals("D")) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR] 유효한 값을 입력해주세요. (위: U, 아래: D)");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static Boolean readGameCommand() {
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        if (input.equals("R")) {
            return true;
        }
        if (input.equals("Q")) {
            return false;
        }
        throw new IllegalArgumentException("[ERROR] 유효한 값을 입력해주세요. (재시도: R, 종료: Q)");
    }
}
