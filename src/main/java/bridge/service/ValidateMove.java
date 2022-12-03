package bridge.service;

public class ValidateMove {


    public String validate(String move){
        if(!(move.equals("U") || move.equals("D"))){
            throw new IllegalArgumentException("[ERROR] 움직임으로는 U, D의 커맨드만 입력받을 수 있습니다.");
        }
        return move;
    }
}
