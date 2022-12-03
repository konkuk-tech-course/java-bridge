package bridge.service;

import bridge.view.OutputView;

public class ValidateSize {


    public int validate(String size) {
        int sizeInt = 0;
        try {
            sizeInt = validateNumber(size);
            validateSize(sizeInt);
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

    public void validateSize(int sizeInt) {
        try {
            if (sizeInt < 3 || sizeInt > 20) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20 사이입니다.");
        }


    }
}