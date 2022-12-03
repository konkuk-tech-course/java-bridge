package bridge.domain;

import bridge.domain.constant.UserStatus;

public class User {
    private UserStatus status;
    private int round;
    private int attemptCount;

    public User() {
        this.status = UserStatus.PLAY;
        this.round = 0;
        this.attemptCount = 0;
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
