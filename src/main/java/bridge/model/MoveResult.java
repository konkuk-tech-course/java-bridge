package bridge.model;// @ author ninaaano

import java.util.stream.Stream;

public enum MoveResult {
    UP_SUCCESS("U","O",true),
    UP_FAIL("U","X",false),
    DOWN_SUCCESS("D","O",true),
    DOWN_FAIL("D","X",false);

    private final String command;
    private final String mark;
    private final boolean check;

    MoveResult(String command, String mark, boolean check) {
        this.command = command;
        this.mark = mark;
        this.check = check;
    }

    public boolean isCheck(){
        return check;
    }

    public static MoveResult toMatch(String command, boolean match) {
        return Stream.of(MoveResult.values())
                .filter(direction -> direction.getCommand().equals(command))
                .filter(count -> count.isCheck() == match)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public static String getCommand() {
        return command;
    }
}


