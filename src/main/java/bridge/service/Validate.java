package bridge.service;

public class Validate {


    public int validateSize(String size) {
        int sizeInt = 0;
        try {
            sizeInt = validateNumber(size);
            validateSizeRange(sizeInt);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return sizeInt;
    }

    private int validateNumber(String size) {
        try {
            return Integer.parseInt(size);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 다리의 사이즈는 숫자여야 합니다.");
        }
    }

    public void validateSizeRange(int sizeInt) {
        try {
            if (sizeInt < 3 || sizeInt > 20) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20 사이입니다.");
        }
    }


    public String validateMove(String move){
        if(!move.equals("U") && !move.equals("D")){
            throw new IllegalArgumentException("[ERROR] 움직임으로는 U, D의 커맨드만 입력받을 수 있습니다.");
        }
        return move;
    }

    public String validateCommand(String readBridgeSize) {
        if(!readBridgeSize.equals("R") && !readBridgeSize.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 게임 종료 재시작으로는 R,Q의 커맨드만 입력 가능합니다.");
        }
        return readBridgeSize;
    }
}