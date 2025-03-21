import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LadderTest {

    @Test
    void testNoLines() {
        LadderGame ladder = new LadderGame(5, 3);

        assertEquals(-1, ladder.run(-1));
        assertEquals(-1, ladder.run(0));
        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));

    }

    @Test
    void testLines() {
        LadderGame ladder = new LadderGame(5, 3);

        ladder.drawLine(new Position(-1, 0));
        ladder.drawLine(new Position(0, 0));
        ladder.drawLine(new Position(1, 0));
        ladder.drawLine(new Position(1, 1));


        assertEquals(3, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(-1, ladder.run(4));
        assertEquals(2, ladder.run(3));
    }
    @Test
    void testLines2() {
        LadderGame ladder = new LadderGame(5, 1); // 1이면 다리 생성 못함

        ladder.drawLine(new Position(-1, 0));
        ladder.drawLine(new Position(0, 0));
        ladder.drawLine(new Position(1, 0));
        ladder.drawLine(new Position(1, 1));

        assertEquals(1, ladder.run(1));
        assertEquals(-1, ladder.run(2));
        assertEquals(-1, ladder.run(4));
        assertEquals(-1, ladder.run(3));

    }
    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderGame(5, -1);
        });
    }

}