import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 이동 로직이 정상적으로 동작")
    void givenLadder_whenRunning_thenReturnCorrectPosition() {
        Ladder ladder = new Ladder(NaturalNumber.of(5), NaturalNumber.of(4));

        ladder.drawLine(Position.of(NaturalNumber.of(1), NaturalNumber.of(1)));  // 1번 위치에서 선을 그림
        ladder.drawLine(Position.of(NaturalNumber.of(2), NaturalNumber.of(2)));  // 2번 위치에서 선을 그림

        assertThat(ladder.run(NaturalNumber.of(1))).isEqualTo(2); // 1번에서 시작 → 2번 도착
        assertThat(ladder.run(NaturalNumber.of(2))).isEqualTo(1); // 2번에서 시작 → 1번 도착
    }

    @Test
    @DisplayName("유효하지 않은 위치에 선을 그리면 예외 발생")
    void givenInvalidPosition_whenDrawingLine_thenThrowsException() {
        Ladder ladder = new Ladder(NaturalNumber.of(5), NaturalNumber.of(4));
        assertThatThrownBy(() -> ladder.drawLine(Position.of(NaturalNumber.of(6), NaturalNumber.of(4))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.OUT_OF_BOUNDS_COL_POSITION.getErrorMessage());
    }
}