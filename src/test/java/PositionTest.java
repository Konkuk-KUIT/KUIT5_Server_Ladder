import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("유효한 좌표값으로 Position 객체 생성")
    void givenValidPosition_whenCreating_thenSuccess() {
        Position position = Position.of(NaturalNumber.of(3), NaturalNumber.of(5));
        assertThat(position.getX()).isEqualTo(3);
        assertThat(position.getY()).isEqualTo(5);
    }

    @Test
    @DisplayName("음수 좌표를 입력하면 예외 발생")
    void givenNegativePosition_whenCreating_thenThrowsException() {
        assertThatThrownBy(() -> Position.of(NaturalNumber.of(-1), NaturalNumber.of(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_NUMBER_OF_POSITION.getErrorMessage());
    }
}