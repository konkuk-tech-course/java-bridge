package bridge.model;// @ author ninaaano

import java.util.Arrays;

public enum GameProgress {
    PLAY("R"),
    STOP("Q");

    private String command;

    GameProgress(String command) {
        this.command = command;
    }

    public boolean isPlay() {
        return this.equals(PLAY);
    }

    public boolean isStop() {
        return this.equals(STOP);
    }

    public GameProgress gameStart(){
        return PLAY;
    }

    public GameProgress getProgerss(String command){
        return Arrays.stream(values())
                .filter(status -> status.command.equals(command))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("R과 Q중 하나의 값만 입력해주세요."));
    }
}
