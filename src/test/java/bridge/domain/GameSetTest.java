package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameSetTest {

    GameResult gameResult = new GameResult();
    @Test
    void retry() {
        String readCommand = "R";
        if(readCommand.equals(GameCommand.RETRY.getCommand())){
            gameResult.setGameResult(true);
        }
        Assertions.assertThat(gameResult.getGameResult()).isTrue();


    }

    @Test
    void quit(){
        String readCommand2 = "Q";
        if(readCommand2.equals(GameCommand.QUIT.getCommand())){
            gameResult.setGameResult(false);
        }
        Assertions.assertThat(gameResult.getGameResult()).isFalse();
    }



}