package ladderGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PositiveNumberTest {

    @Test
    @DisplayName("Positive: 자연수여야 한다.")
    void shouldCreatePositiveNumberSuccessfullyWhenPositiveNumber() {
        // given
        final int validNumber = 1;

        // when
        PositiveNumber positiveNumber = new PositiveNumber(validNumber);

        // then
        assertThat(positiveNumber).isNotNull();
        assertThat(positiveNumber.getNumber()).isEqualTo(validNumber);
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("Negative: 자연수여야 한다.")
    void shouldThrowExceptionWhenNotPositiveNumber(int invalidNumber) {
        // given
        String expectedErrorMessage = ExceptionCode.NOT_POSITIVE_INPUT.getMessage();

        // when & then
        assertThatThrownBy(() -> new PositiveNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedErrorMessage);
    }
}