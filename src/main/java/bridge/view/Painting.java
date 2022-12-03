package bridge.view;

import bridge.view.OutputView;
import java.util.stream.Collectors;

public class Painting {
    private static OutputView outputView= new OutputView();
    public static void paint(String upState, String downState){
        outputView.printMap(upState.chars().boxed().map(Character::toString).collect(
            Collectors.joining(" | ", "[ ", " ]")));
        outputView.printMap(downState.chars().boxed().map(Character::toString).collect(Collectors.joining(" | ", "[ ", " ]")));
    }

}
