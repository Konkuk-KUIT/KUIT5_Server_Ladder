package ladderGame;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("Positive: 가로와 세로 모두 자연수여야 한다.")
    void shouldCreatePositionSuccessfullyWhenPositiveNumbers() {
        // given
        final int validRow = 1;
        final int validColumn = 2;

        // when
        Position position = new Position(validRow, validColumn);

        // then
        assertThat(position).isNotNull();
        assertThat(position.getRow()).isEqualTo(validRow);
        assertThat(position.getColumn()).isEqualTo(validColumn);
    }


    @ParameterizedTest
    @CsvSource(value = {"-1, 1", "0, 1", "1, -1", "1, 0"})
    @DisplayName("Negative: 가로와 세로 모두 자연수여야 한다.")
    void shouldThrowExceptionWhenNotPositiveNumbers(int invalidRow, int invalidColumn) {
        // given
        String expectedErrorMessage = ExceptionCode.NOT_POSITIVE_INPUT.getMessage();

        // when & then
        assertThatThrownBy(() -> new Position(invalidRow, invalidColumn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);

    }
}