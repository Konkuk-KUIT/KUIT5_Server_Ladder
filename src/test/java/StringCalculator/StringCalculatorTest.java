package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static StringCalculator.ErrorMessage.NO_INTEGER;
import static StringCalculator.ErrorMessage.NO_POSITIVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 값이 들어온 경우")
    public void testNullorEmpty(String givenText) {
        assertThat(StringCalculator.splitAndSum(givenText)).isEqualTo(0);
    }

    @Test
    @DisplayName("정수 하나만 들어온 경우")
    public void testOneInteger() {
        assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자로 정수 두 개가 들어온 경우")
    public void testTwoIntegerWithComma() {
        assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표와 콜론 구분자로 정수 두 개가 들어온 경우")
    public void testTwoIntegerWithCommaAndColon() {
        assertThat(StringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("정수가 아닌 값을 입력한 경우 예외처리")
    public void throwExceptionWhenNegative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(NO_INTEGER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가,2:3", "*,2:3", "1.1,2:3"})
    @DisplayName("음수를 입력한 경우 예외처리")
    public void throwExceptionWhenNotInteger(String givenText) {
        assertThatThrownBy(() -> StringCalculator.splitAndSum(givenText))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(NO_POSITIVE.getMessage());
    }
}