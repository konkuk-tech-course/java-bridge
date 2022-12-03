package bridge.domain;

import bridge.domain.constant.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    private static User user;

    @BeforeEach
    void beforeEach() {
        user = new User();
    }

    @Test
    void When_PlayRound_Expect_RoundIncreasedByOne() {
        int round = user.getRound();
        user.playRound();
        assertThat(user.getRound()).isEqualTo(round + 1)
                .isEqualTo(1);
    }

    @Test
    void When_Fail_Expect_StatusAsFail() {
        user.fail();
        assertThat(user.getStatus()).isEqualTo(UserStatus.FAIL);
    }

    @Test
    void When_Retry_Expect_AttemptCountIncreasedByOne() {
        int attemptCount = user.getAttemptCount();
        user.retry();
        assertThat(user.getAttemptCount()).isEqualTo(attemptCount + 1)
                .isEqualTo(2);
    }

    @Test
    void When_Retry_Expect_RoundDecreasedByOne() {
        user.playRound();
        int round = user.getRound();
        user.retry();
        assertThat(user.getRound()).isEqualTo(round - 1)
                .isEqualTo(0);
    }

    @Test
    void When_Retry_Expect_StatusAsPlay() {
        user.playRound();
        user.retry();
        assertThat(user.getStatus()).isEqualTo(UserStatus.PLAY);
    }

    @Test
    void When_ClearGame_Expect_StatusAsSuccess() {
        user.clearGame();
        assertThat(user.getStatus()).isEqualTo(UserStatus.SUCCESS);
    }
}
