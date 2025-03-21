import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    //run,draw 기능 확인
    @Test
    void ladder_run_and_drawLine_delegation() {
        Ladder ladder = new Ladder(4, 3);

        // 빈 사다리 → 이동 없음
        assertEquals(0, ladder.run(0));
        assertEquals(1, ladder.run(1));

        // (1,1)에 줄 추가 → 이동 확인
        ladder.drawLine(1, 1);
        assertEquals(2, ladder.run(1));
        assertEquals(1, ladder.run(2));
    }

    //잘못된 입력 예외 확인
    @Test
    void ladder_invalid_start_column() {
        Ladder ladder = new Ladder(4, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            ladder.run(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ladder.run(4);
        });
    }
}