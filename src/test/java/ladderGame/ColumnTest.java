package ladderGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ColumnTest {
    private final static int person = 5;

    @Test
    @DisplayName("Positive: 세로는 사람의 수 이하여야 한다.")
    void shouldCreateRowSuccessfullyWhenPositiveNumberAndNotGreaterThanHeight() {
        // given
        final int validNumber = 1;
        Column column = new Column(validNumber, person);

        // when & then
        assertThat(column).isNotNull();
        assertThat(column.getNumber()).isEqualTo(validNumber);
    }


    @Test
    @DisplayName("Negative: 세로는 사람의 수 이하여야 한다.")
    void shouldThrowExceptionWhenPositiveNumberAndGreaterThanHeight() {
        // given
        final int invalidNumber = 6;

        // when & then
        assertThatThrownBy(() -> new Column(invalidNumber, person))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionCode.COLUMN_OUT_OF_RANGE.getMessage());
    }
}