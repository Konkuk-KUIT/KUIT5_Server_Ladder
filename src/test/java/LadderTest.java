import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    private Ladder ladder=new Ladder(5,4);

    @ParameterizedTest
    @CsvSource({"1, 2", "0, 0", "2, 3"})
    @DisplayName("올바른 사다리 라인 테스트")
    void testDrawLine(int targetCol, int startRow) {
        assertDoesNotThrow(() -> ladder.drawLine(targetCol, startRow));
        // 현재 코드 상 배열 내부에서 라인이 중복되거나 유효하지 않은 연결일 때 해당 입력은 무시된다.
        // 따로 예외처리를 해야하는지?
    }

    @Test
    @DisplayName("잘못된 사다리 위치 테스트")
    void testParserDrawLineFailed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(-1, 2));
        assertEquals("잘못된 사다리 위치입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("잘못된 시작 위치 테스트")
    @CsvSource({"-1", "4"}) // 배열 경계 값
    void testParserRunFailed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> ladder.run(-1));
        assertEquals("잘못된 시작 위치입니다.", exception.getMessage());
    }

    @Test
    //@CsvSource()
    void testRun() {
        //이거 매개변수 리스트로 간소화할 수 없나
        // given
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);

        // when
        int result = ladder.run(0);

        // then
        assertEquals(3, result);
    }
}