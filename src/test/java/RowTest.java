import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {

    @Test
    @DisplayName("중복된 라인 생성 불가능 테스트(Row의 drawLineOnNode 테스트)")
    void drawLineOnSamePosition_shouldThrowException() {
        // given
        Row row = Row.of(5);

        // when
        row.drawLineOnNode(Position.of(1));

        // then
        // 같은 위치에 다시 그으면 예외
        assertThrows(IllegalArgumentException.class, () -> {
            row.drawLineOnNode(Position.of(1));
        });
    }

    @Test
    @DisplayName("일자 라인 생성 불가능 테스트(Row의 drawLineOnNode 테스트)")
    void drawLineOnOverlappingPosition_shouldThrowException() {
        // given
        Row row = Row.of(5);

        // when
        // 1번-2번 라인생성
        row.drawLineOnNode(Position.of(1));

        // then
        // 연속된 위치(2번)에 다시 라인을 그으려 하면 예외
        assertThrows(IllegalArgumentException.class, () -> {
            row.drawLineOnNode(Position.of(2));
        });
    }
}
