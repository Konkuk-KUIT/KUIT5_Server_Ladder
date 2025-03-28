package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    @DisplayName("방향 값 확인")
    void testDirectionValues() {
        // Direction enum의 값 확인
        assertThat(Direction.RIGHT.getValue()).isEqualTo(1);
        assertThat(Direction.NONE.getValue()).isEqualTo(0);
        assertThat(Direction.LEFT.getValue()).isEqualTo(-1);
    }

    @Test
    @DisplayName("방향 이름 확인")
    void testDirectionNames() {
        // Direction enum의 이름 확인
        assertThat(Direction.RIGHT.name()).isEqualTo("RIGHT");
        assertThat(Direction.NONE.name()).isEqualTo("NONE");
        assertThat(Direction.LEFT.name()).isEqualTo("LEFT");
    }

    @ParameterizedTest
    @CsvSource({
            "1, RIGHT",
            "0, NONE",
            "-1, LEFT"
    })
    @DisplayName("값으로 방향 찾기")
    void testFindDirectionByValue(int value, Direction expectedDirection) {
        // 값으로 Direction 찾기 테스트
        Direction direction = null;
        for (Direction dir : Direction.values()) {
            if (dir.getValue() == value) {
                direction = dir;
                break;
            }
        }
        assertThat(direction).isEqualTo(expectedDirection);
    }
}