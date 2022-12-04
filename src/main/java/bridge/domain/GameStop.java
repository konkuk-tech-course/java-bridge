package bridge.domain;

public class GameStop {

    private GameResult gameResult;

    public GameStop() {
        this.gameResult = new GameResult();
    }
    // 도메인보다는 컨트롤러의 성향이 더 강한 코드 -> 좀 더 생각
    public boolean isRetry(String readCommandValidate, BridgeGame bridgeGame) {
        if(readCommandValidate.equals(GameCommand.RETRY.getCommand())){
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
