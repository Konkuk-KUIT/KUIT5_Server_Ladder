import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(5, 4);
    }

    @Test
    @DisplayName("선 잘 그려지는지")
    void testDrawLine() {
        ladder.drawLine(new NonNegativeNumber(1), new NonNegativeNumber(1));
        assertEquals(2, ladder.run(1));
    }

    @Test
    @DisplayName("선이 없을 때 이동 없이 내려감")
    void testRunWithoutLines() {
        assertEquals(1, ladder.run(1));
    }

    @Test
    @DisplayName("여러 선이 있을 때 이동 잘 하는지")
    void testRunWithMultipleLines() {
        ladder.drawLine(new NonNegativeNumber(1), new NonNegativeNumber(2));
        ladder.drawLine(new NonNegativeNumber(2), new NonNegativeNumber(1));
        assertEquals(2, ladder.run(1));
    }

    @Test
    @DisplayName("높이나 인원이 0일 경우 예외 발생")
    void testInvalidLadderCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 3));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(3, 0));
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되는지")
    void testLadderNotNullAfterCreation() {
        assertNotNull(ladder);
    }

    @Test
    @DisplayName("사다리에 연속된 줄을 그리면 예외 발생")
    void testDrawLineContinuous() {
        ladder.drawLine(new NonNegativeNumber(1), new NonNegativeNumber(1));
        assertThrows(IllegalArgumentException.class, () ->
                ladder.drawLine(new NonNegativeNumber(1), new NonNegativeNumber(2))
        );
    }

    @Test
    @DisplayName("잘못된 위치에 선 그리면 예외 발생")
    void testDrawLineOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () ->
                ladder.drawLine(new NonNegativeNumber(5), new NonNegativeNumber(1)) // row out of bounds
        );
        assertThrows(IllegalArgumentException.class, () ->
                ladder.drawLine(new NonNegativeNumber(1), new NonNegativeNumber(3)) // col out of bounds
        );
    }
}
