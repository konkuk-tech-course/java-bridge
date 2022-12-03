package bridge.view;

public class ConvertResult {


    public static String convert(boolean gameResult) {
        if(gameResult==true){
            return GameResultConstant.SUCCESS.getResult();
        }
        return GameResultConstant.FAIL.getResult();
    }
}
