package bridge.domain;

public class GameSet {

    GameResult gameResult;

    public GameSet() {
        this.gameResult = new GameResult();
    }

    public boolean retryOrQuit(String readCommendValidate, BridgeGame bridgeGame) {
        if(readCommendValidate.equals("R")){
            bridgeGame.retry();
            gameResult.setGameResult(true);
            return true;
        }
        gameResult.setGameResult(false);
        return false;
    }

    public boolean getGameResult(){
       return gameResult.getGameResult();
    }
}
