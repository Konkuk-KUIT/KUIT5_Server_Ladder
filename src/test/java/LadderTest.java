import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(5, 4); // Test 전 미리 사다리 세팅
    }

    @Test
    @DisplayName("선 잘 그려지는지 확인")
    void testDrawLine() {
        ladder.drawLine(0, 1);
        assertEquals(2, ladder.run(1));
    }

    @Test
    @DisplayName("선 없을 때 그대로 내려가는지 확인")
    void testRunWithoutLines() {
        assertEquals(1, ladder.run(1));
    }

    @Test
    @DisplayName("선 여러개 있을 때 잘 가는지 확인")
    void testRunWithMultipleLines() {
        ladder.drawLine(0, 1); // 1->2
        ladder.drawLine(1, 2); // 2->3
        ladder.drawLine(2, 1); // 1->2
        assertEquals(2, ladder.run(1));
    }

    @Test
    @DisplayName("잘못된 사람 수, 높이")
    void testInvalidPeopleOrHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(4, 0));
    }
}
