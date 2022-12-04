package bridge.domain;

import bridge.constraints.MoveCode;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }
    // 일치 여부 확인
    public boolean isMatched(Player player, MoveCode moveCode) {
        String command = bridge.get(player.getPosition());
        return moveCode.getStringCode().equals(command);
    }
}
