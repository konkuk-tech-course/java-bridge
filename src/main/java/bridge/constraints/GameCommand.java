package bridge.constraints;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GameCommand {
    NOTHING(""),
    RETRY("R"),
    QUIT("Q");

    private final String command;
    GameCommand(String command) {
        this.command = command;
    }

    private static final Map<String, GameCommand> GAME_COMMANDS =
            Arrays.stream(values())
            .filter(gameCommands -> !gameCommands.equals(NOTHING))
            .collect(Collectors.toMap(
                    gameCommands -> gameCommands.command, Function.identity()));


    public static GameCommand of(final String command) {
        if (!GAME_COMMANDS.containsKey(command)) {
            throw new IllegalArgumentException("R 또는 Q만 입력해 주세요. (R:재시작, Q:종료)");
        }
        return GAME_COMMANDS.get(command);
    }
}
