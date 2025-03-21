import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @Test
    @DisplayName("왼쪽에 선이 있으면 LEFT 반환")
    void givenLeft_whenCallingOf_thenReturnLeft() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("오른쪽에 선이 있으면 RIGHT 반환")
    void givenRight_whenCallingOf_thenReturnRight() {
        assertThat(Direction.of(false, true)).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("양쪽에 선이 없으면 NONE 반환")
    void givenNone_whenCallingOf_thenReturnNone() {
        assertThat(Direction.of(false, false)).isEqualTo(Direction.NONE);
    }
}