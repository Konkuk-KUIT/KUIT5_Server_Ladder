import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaddarDrawRandomLineTest {
    @Test
    @DisplayName("사다리 타기 - 정상 작동")
    void testRun(){
        LadderGame game = LadderGameFactory.createRandomLadderGame(5, 4);
        int result = game.run(2);
        System.out.println("결과 위치: " + result);
    }
}
