import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderRunnerTest {

    @Test
    public void testRun_InvalidStartPosition() { // StartPosition 값이 유효범위를 넘을 경우
        Ladder ladder = new Ladder(3, 4);
        LadderRunner runner = new LadderRunner();

        assertThrows(IllegalArgumentException.class, () -> runner.run(ladder, -1));

        assertThrows(IllegalArgumentException.class, () -> runner.run(ladder, 4));
    }


    @Test
    public void testRun_NoLines() { // 라인이 아예 없는 경우
        Ladder ladder = new Ladder(3, 4);
        LadderRunner runner = new LadderRunner();

        assertEquals(0, runner.run(ladder, 0));
        assertEquals(1, runner.run(ladder, 1));
        assertEquals(2, runner.run(ladder, 2));
        assertEquals(3, runner.run(ladder, 3));
    }

    @Test
    public void testRun_MoveRightThenLeft() {
        Ladder ladder = new Ladder(2, 4);

        ladder.drawLine(0, 1);
        ladder.drawLine(1, 1);

        LadderRunner runner = new LadderRunner();

        assertEquals(1, runner.run(ladder, 1));
        assertEquals(2, runner.run(ladder, 2));
    }

    @Test
    public void testRun_StartAtFirstCol() {
        Ladder ladder = new Ladder(1, 3);

        ladder.drawLine(0, 0);

        LadderRunner runner = new LadderRunner();

        assertEquals(1, runner.run(ladder, 0)); // 0 → 1
        assertEquals(0, runner.run(ladder, 1)); // 1 → 0
    }

    @Test
    public void testRun_StartAtLastCol() {
        Ladder ladder = new Ladder(1, 3);

        ladder.drawLine(0, 1);

        LadderRunner runner = new LadderRunner();

        assertEquals(2, runner.run(ladder, 1));
        assertEquals(1, runner.run(ladder, 2));
    }

    @Test
    public void testRun_LargeSize() {
        Ladder ladder = new Ladder(6, 7);

        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);
        ladder.drawLine(3, 3);
        ladder.drawLine(4, 4);
        ladder.drawLine(5, 5);

        LadderRunner runner = new LadderRunner();

        assertEquals(6, runner.run(ladder, 0));
        assertEquals(0, runner.run(ladder, 1));
        assertEquals(1, runner.run(ladder, 2));
        assertEquals(2, runner.run(ladder, 3));
        assertEquals(3, runner.run(ladder, 4));
        assertEquals(4, runner.run(ladder, 5));
        assertEquals(5, runner.run(ladder, 6));
    }

    @Test
    public void testRun_MoreComplex() {
        Ladder ladder = new Ladder(7, 8);

        ladder.drawLine(0, 0);
        ladder.drawLine(0, 3);
        ladder.drawLine(0, 5);
        ladder.drawLine(1, 1);
        ladder.drawLine(1, 6);
        ladder.drawLine(2, 2);
        ladder.drawLine(2, 4);
        ladder.drawLine(2, 6);
        ladder.drawLine(3, 0);
        ladder.drawLine(3, 3);
        ladder.drawLine(3, 5);
        ladder.drawLine(4, 2);
        ladder.drawLine(4, 5);
        ladder.drawLine(5, 0);
        ladder.drawLine(5, 2);
        ladder.drawLine(5, 5);
        ladder.drawLine(6, 1);
        ladder.drawLine(6, 4);
        ladder.drawLine(6, 6);


        LadderRunner runner = new LadderRunner();

        assertEquals(5, runner.run(ladder, 0));
        assertEquals(0, runner.run(ladder, 1));
        assertEquals(2, runner.run(ladder, 2));
        assertEquals(7, runner.run(ladder, 3));
        assertEquals(1, runner.run(ladder, 4));
        assertEquals(4, runner.run(ladder, 5));
        assertEquals(3, runner.run(ladder, 6));
        assertEquals(6, runner.run(ladder, 7));
    }

}

