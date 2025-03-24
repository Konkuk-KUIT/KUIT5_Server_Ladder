import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    void testLines2() {
        Ladder ladder = new Ladder(5, 4);

//        ladder.drawLine(new Position(-1, 0));
        ladder.drawLine(new Position(0, 5));  // y<5 여야 그려짐
//        ladder.drawLine(new Position(1, 0));
//        ladder.drawLine(new Position(1, 1));

//        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(3, ladder.run(3));
        assertEquals(4, ladder.run(4));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each1");
    }
    @AfterEach
    void reset() {
        System.out.println("After Each2");
    }

    @Test
    @DisplayName("123")
    void testCode(){
        // given
        
        // when
        
        // then

    }

}