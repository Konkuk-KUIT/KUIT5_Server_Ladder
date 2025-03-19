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
    ladder.drawLine(0, 0);
    ladder.drawLine(1, 1);
    ladder.drawLine(2, 2);

    int result = ladder.run(0);  // 실행 후 반환값 저장
    assertEquals(3, result);
//    assertDoesNotThrow(() -> ladder.run(0));
}



}