package ladderGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    private int person;
    private int ladderHeight;
    private static Ladder ladder;

    @BeforeEach
    void setUp() {
        person = 5;
        ladderHeight = 5;
        ladder = new Ladder(person, ladderHeight);
    }

    @Test
    @DisplayName("Positive: 사람과 사다리의 높이는 모두 자연수여야 한다.")
    void shouldCreateLadderSuccessfullyWhenPositiveNumbers() {
        // given
        final int validRow = 1;
        final int validColumn = 1;
        Position validPosition = new Position(validRow, validColumn);

        // then
        assertThat(ladder).isNotNull();
        assertThat(ladder.getWidth()).isEqualTo(person);
        assertThat(ladder.getHeight()).isEqualTo(ladderHeight);
        assertThat(ladder.hasLine(validPosition)).isFalse();
    }


    @ParameterizedTest
    @CsvSource(value = {"-1, 1", "0, 1", "1, -1", "1, 0"})
    @DisplayName("Negative: 사람과 사다리의 높이는 모두 자연수여야 한다.")
    void shouldThrowExceptionWhenNotPositiveNumbers(int invalidPerson, int invalidHeight) {
        // given
        String expectedErrorMessage = ExceptionCode.NOT_POSITIVE_INPUT.getMessage();

        // when & then
        assertThatThrownBy(() -> new Ladder(invalidPerson, invalidHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }


    @Test
    @DisplayName("Negative: 그릴 선의 가로는 사다리의 높이보다 작아야 한다.")
    void shouldThrowExceptionWhenRowOutOfRange() {
        // given
        final int invalidRow = 6;
        final int validColumn = 1;
        String expectedErrorMessage = ExceptionCode.ROW_OUT_OF_RANGE.getMessage();

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(new Position(invalidRow, validColumn)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }


    @Test
    @DisplayName("Negative: 그릴 선의 세로는 사람의 수보다 작아야 한다.")
    void shouldThrowExceptionWhenColumnOutOfRange() {
        // given
        final int validRow = 1;
        final int invalidColumn = 6;
        String expectedErrorMessage = ExceptionCode.COLUMN_OUT_OF_RANGE.getMessage();

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(new Position(validRow, invalidColumn)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }



    @Test
    @DisplayName("Negative: 그릴 선의 위치에 선이 없어야 한다.")
    void shouldThrowExceptionWhenLineExists() {
        // given
        final int validRow = 1;
        final int validColumn = 1;
        String expectedErrorMessage = ExceptionCode.PRESENT_LINE.getMessage();
        ladder.drawLine(new Position(validRow, validColumn));

        // when
        final int invalidRow = validRow;
        final int invalidColumn = validRow;

        // then
        assertThatThrownBy(() -> ladder.drawLine(new Position(invalidRow, invalidColumn)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }



    @ParameterizedTest
    @CsvSource(value = {"0, -1", "0, 1"})
    @DisplayName("Negative: 그릴 선의 위치에 인접한 선이 없어야 한다.")
    void shouldThrowExceptionWhenAdjLineExists(int rowOffset, int columnOffset) {
        // given
        final int validRow = 3;
        final int validColumn = 3;
        String expectedErrorMessage = ExceptionCode.ADJACENT_LINE.getMessage();
        ladder.drawLine(new Position(validRow, validColumn));

        // when
        final int invalidRow = validRow + rowOffset;
        final int invalidColumn = validRow + columnOffset;

        // then
        assertThatThrownBy(() -> ladder.drawLine(new Position(invalidRow, invalidColumn)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }

    @Test
    @DisplayName("Positive: 적절한 입력에 대해서 선이 그어져야 한다.")
    void shouldDrawLineWhenValidNumbers() {
        // given
        final int validRow = 3;
        final int validColumn = 3;
        Position validPosition = new Position(validRow, validColumn);
        ladder.drawLine(new Position(validRow, validColumn));

        // then
        assertThat(ladder.hasLine(validPosition)).isTrue();
    }

}