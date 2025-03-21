import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    public void setUp() {
        ladder = new Ladder(3, 5);
    }

    @Test
    public void testInvalidLadderSize() { // 범위에 맞지 않는 숫자로 사다리를 생성할 경우
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 3));
        assertThrows(IllegalArgumentException.class, () -> new Ladder(3, 1));
    }

    @Test
    public void testDrawLine_Success() { // 성공 테스트
        ladder.drawLine(1, 2);

        LineValue[] states = ladder.getRows()[1].getLineStates();
        assertEquals(LineValue.RIGHT, states[2]);
        assertEquals(LineValue.LEFT, states[3]);
    }

    @Test
    public void testDrawLine_InvalidRow() { // row 범위를 초과한 값을 넣었을 경우
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(5, 1));
    }

    @Test
    public void testDrawLine_InvalidColumn() { // column 끝값(예외처리되는 값) 걸리는 값을 넣었을 경우
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 4));
    }
}