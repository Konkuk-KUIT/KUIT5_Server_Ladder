import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    private Ladder ladder=new Ladder(5,4);

//    @Test
//    void drawLineTest() {
//        ladder.drawLine(1,2);
//        assertEquals();
//
//    }
    @Test
    void runTest() {
    ladder.drawLine(1, 0);
    ladder.drawLine(2, 1);
    ladder.drawLine(1, 2);
    assertDoesNotThrow(() -> ladder.run(0));
}



}