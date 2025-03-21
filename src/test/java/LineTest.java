import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("선을 정상적으로 그릴 수 있다.")
    void givenValidPosition_whenDrawingLine_thenSuccess() {
        Line line = new Line(5);
        line.draw(2);
        assertThat(line.getDirectionAt(2)).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("연속된 위치에 선을 그리면 예외 발생")
    void givenContinuousLine_whenDrawingLine_thenThrowsException() {
        Line line = new Line(5);
        line.draw(2);
        assertThatThrownBy(() -> line.draw(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DISALLOWED_CONTINUOUS_LINE.getErrorMessage());
    }

    @Test
    @DisplayName("이미 존재하는 위치에 선을 그리면 예외 발생")
    void givenExistingLine_whenDrawingSamePosition_thenThrowsException() {
        Line line = new Line(5);
        line.draw(2);
        assertThatThrownBy(() -> line.draw(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LINE_ALREADY_EXISTS.getErrorMessage());
    }
}