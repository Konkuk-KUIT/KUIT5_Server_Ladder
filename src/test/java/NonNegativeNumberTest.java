import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NonNegativeNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("NonNegativeNumber 생성자 검증")
    public void testNonNegativeNumber(int input) {
        NonNegativeNumber naturalNumber = new NonNegativeNumber(input);

        assertThat(naturalNumber.getNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("NonNegativeNumber 생성자 throw 검증")
    public void testNonNegativeNumberThrow(int input) {
        assertThatThrownBy(() -> new NonNegativeNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_NEGATIVE_NUMBER_CANNOT_BE_NEGATIVE.getMessage());
    }
}
