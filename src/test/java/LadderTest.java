import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


class LadderTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        // given
        int numberOfRow = 3;
        int numberOfPerson = 5;

        // when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        // then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사다리 그리기 행 초과 예외")
    void throwLadderDrawingRowExceedsLimitException() {
        // when
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(2, numberOfPerson);

        // then
        assertThatThrownBy(() -> ladder.drawLine(2, 1))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    @DisplayName("사다리 그리기 행 미만 예외")
    void throwLadderDrawingRowBelowLimitException() {
        // when
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(2, numberOfPerson);

        // then
        assertThatThrownBy(() -> ladder.drawLine(-1, 1))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        // when
        int numberOfPerson = 3;
        Ladder ladder = new Ladder(1, numberOfPerson);

        // given
        int nthOfPerson = 4;

        // then
        assertThatThrownBy(() -> ladder.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        // when
        int numberOfPerson = 4;
        int row = 3;
        Ladder ladder = new Ladder(row, numberOfPerson);

        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 0);

        // given
        int nthOfPerson = 0;

        // then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(2);

        // given
        nthOfPerson = 1;

        // then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(1);

        // given
        nthOfPerson = 2;

        // then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(0);
    }
}
