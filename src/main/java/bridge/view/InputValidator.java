package bridge.view;// @ author ninaaano

import java.util.List;

public class InputValidator {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final List<String> VALID_MOVING = List.of("U", "D");
    private static final List<String> VALID_COMMAND = List.of("R","Q");

    // 숫자 이외, 요구한 문자 이외, 범위 외
    private static final String INVALID_RANGE_BRIGDE_MESSAGE = "다리 길이는 3에서 20사이의 숫자여야합니다.";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 이외 값이 들어올 수 없습니다.";
    private static final String INVALID_MOVING_MESSAGE = "U:(위) / D:(아래)중 하나의 값만 입력 가능합니다.";
    private static final String INVALID_COMMAND_MESSAGE = "R:(게임재시작) / Q:(종료)중 하나의 값만 입력 가능합니다.";

    public void validateBridgeSize(String inputBridgeSize){
        Integer size = toInteger(inputBridgeSize);
        validateBridgeSizeCheck(size);
    }

    private Integer toInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateBridgeSizeCheck(Integer size) {
        if(size < MIN_SIZE || size > MAX_SIZE){
            throw new IllegalArgumentException(INVALID_RANGE_BRIGDE_MESSAGE);
        }
    }

    public void validateMoving(String input){
        if(!VALID_MOVING.contains(input)){
            throw new IllegalArgumentException(INVALID_MOVING_MESSAGE);
        }
    }

    public void validateCommand(String input){
        if(!VALID_COMMAND.contains(input)){
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }


}
