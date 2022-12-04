package bridge.view;

public class InputConverter {

    public static String convertToCode(Integer i) {
        if (i == 1){
            return "U";
        }
        if (i == 0) {
            return "D";
        }
        throw new IllegalArgumentException("[ERROR] Input을 변환 할 수 없습니다.");
    }
}
