package bridge.service;

import bridge.LocationState;
import bridge.domain.GameCommand;

public class Validate {

    private final int MIN_RANGE=3;
    private final int MAX_RANGE=20;

    public int validateSize(String size) {
        int sizeInt = 0;
        try {
            sizeInt = validateNumber(size);
            validateSizeRange(sizeInt);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return sizeInt;
    }

    private int validateNumber(String size) {
        try {
            return Integer.parseInt(size);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_SIZE_NUMBER.message());
        }
    }

    public void validateSizeRange(int sizeInt) {
        try {
            if (sizeInt < MIN_RANGE || sizeInt > MAX_RANGE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_SIZE_RANGE.message());
        }
    }


    public String validateMove(String move){
        if(!move.equals(LocationState.UP.getState()) && !move.equals(LocationState.DOWN.getState())){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MOVE_INPUT.message());
        }
        return move;
    }

    public String validateCommand(String readBridgeSize) {
        if(isRightCommand(readBridgeSize)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_COMMAND_INPUT.message());
        }
        return readBridgeSize;
    }

    private static boolean isRightCommand(String readBridgeSize) {
        return !readBridgeSize.equals(GameCommand.RETRY.getCommand()) && !readBridgeSize.equals(
            GameCommand.QUIT.getCommand());
    }
}