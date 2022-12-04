package bridge.model;// @ author ninaaano

import java.util.Arrays;
import java.util.stream.Stream;

public enum Direction {
    UP(1,"U"),
    DOWN(0,"D")
    ;

    private static final String INVALID_INPUT_COMMAND_MESSAGE = "U와 D중 입력해주세요.";

    private final Integer code;
    private final String command;

    Direction(Integer code, String command) {
        this.code = code;
        this.command = command;
    }

    public String getCommand(){
        return command;
    }

    public static Direction toCommand(int code) {
        return Stream.of(values())
                .filter(direction -> direction.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_COMMAND_MESSAGE));
    }
//
//    public static Direction getCommand(String command){
//        return Arrays.stream(values())
//                .filter(direction -> direction.command.equals(command))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT_COMMAND_MESSAGE));
//    }

    public boolean isNotEqualsDirection(Direction direction){
        return this != direction;
    }



}
