import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NaturalNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("NaturalNumber 생성자 검증")
    public void testNaturalNumber(int input) {
        NaturalNumber naturalNumber = new NaturalNumber(input);

        assertThat(naturalNumber.getNumber()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    @DisplayName("NaturalNumber 생성자 throw 검증")
    public void testNaturalNumberThrow(int input) {
        assertThatThrownBy(() -> new NaturalNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NATURAL_NUMBER_CANNOT_BE_NEGATIVE_OR_ZERO.getMessage());
    }
}
