package bridge.view;

public class ConvertResult {


    public static String convert(boolean gameResult) {
        if(gameResult==true){
            return "성공";
        }
        return "실패";
    }
}
