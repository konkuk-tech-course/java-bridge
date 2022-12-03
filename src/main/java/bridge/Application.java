package bridge;

import bridge.controller.Controller;

import static bridge.constant.Constant.ERROR;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();

        try {
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.print(ERROR.getValue() +e.getMessage());
        }

    }
}
