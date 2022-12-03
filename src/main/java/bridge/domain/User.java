package bridge.domain;

import bridge.domain.constant.UserStatus;

public class User {
    private UserStatus status;
    private int round;
    private int attemptCount;

    public User() {
        this.status = UserStatus.PLAY;
        this.round = 0;
        this.attemptCount = 1;
    }

    public void playRound() {
        round++;
    }

    public void fail() {
        status = UserStatus.FAIL;
    }

    public void retry() {
        round--;
        attemptCount++;
        status = UserStatus.PLAY;
    }

    public void clearGame() {
        status = UserStatus.SUCCESS;
    }

    public UserStatus getStatus() {
        return status;
    }

    public int getRound() {
        return round;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
