import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RowTest {

    @Test
    public void testInitialize_None() { // 초기 값이 NONE으로 되어있는지 확인
        Row row = new Row(5);
        for (LineValue val : row.getLineStates()) {
            assertEquals(LineValue.NONE, val);
        }
    }

    @Test
    public void testDrawLine_Success() { // 성공 경우 확인
        Row row = new Row(5);
        row.drawLine(2);
        LineValue[] states = row.getLineStates();

        assertEquals(LineValue.RIGHT, states[2]);
        assertEquals(LineValue.LEFT, states[3]);
    }

    @Test
    public void testDrawLine_LastPosition() { // 끝값 예외처리 확인
        Row row = new Row(5);
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(4)); // 마지막 칸 오른쪽 불가
    }

    @Test
    public void testDrawLine_SamePosition() {
        Row row = new Row(5);
        row.drawLine(2);
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(2)); // 똑같은 자리에 그리려고 할 때 확인
    }

    @Test
    public void testDrawLine_LineChaining() { // 라인 두 개가 이어지는 경우 예외처리 확인
        Row row = new Row(5);
        row.drawLine(2);
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(3));
    }

    @Test
    public void testDrawLine_ValidEnd_Success() { // 유효한 범위 내의 끝값 정상 처리 확인
        Row row = new Row(5);
        row.drawLine(0); // 시작점에서
        row.drawLine(3); // 끝 직전에서

        LineValue[] states = row.getLineStates();
        assertEquals(LineValue.RIGHT, states[0]);
        assertEquals(LineValue.LEFT, states[1]);
        assertEquals(LineValue.RIGHT, states[3]);
        assertEquals(LineValue.LEFT, states[4]);
    }
}