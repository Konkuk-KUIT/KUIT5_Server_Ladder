import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LadderTest {

    @Test
    void testNoLines() {
        Ladder ladder = new Ladder(5, 3);

        assertEquals(-1, ladder.run(-1));
        assertEquals(-1, ladder.run(0));
        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));

    }

    @Test
    void testLines() {
        Ladder ladder = new Ladder(5, 3);

        ladder.drawLine(new Position(-1, 0));
        ladder.drawLine(new Position(0, 0));
        ladder.drawLine(new Position(1, 0));
        ladder.drawLine(new Position(1, 1));

        assertEquals(3, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(-1, ladder.run(4));
        assertEquals(2, ladder.run(3));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each1");
    }
    @AfterEach
    void reset() {
        System.out.println("After Each2");
    }



}