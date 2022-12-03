package bridge;

import bridge.controller.Controller;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();

        try {
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR]"+e.getMessage());
        }

    }
}
