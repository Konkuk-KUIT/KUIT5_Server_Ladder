package ladderGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {
    private final static int height = 5;

    @Test
    @DisplayName("Positive: 가로는 사다리의 높이 이하여야 한다.")
    void shouldCreateRowSuccessfullyWhenPositiveNumberAndNotGreaterThanHeight() {
        // given
        final int validNumber = 1;
        Row row = new Row(validNumber, height);

        // when & then
        assertThat(row).isNotNull();
        assertThat(row.getNumber()).isEqualTo(validNumber);
    }


    @Test
    @DisplayName("Negative: 가로는 사다리의 높이 이하여야 한다.")
    void shouldThrowExceptionWhenPositiveNumberAndGreaterThanHeight() {
        // given
        final int invalidNumber = 6;

        // when & then
        assertThatThrownBy(() -> new Row(invalidNumber, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionCode.ROW_OUT_OF_RANGE.getMessage());
    }
}