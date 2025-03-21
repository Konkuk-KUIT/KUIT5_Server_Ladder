import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class NaturalNumberTest {

    @Test
    @DisplayName("1 이상의 숫자를 입력하면 정상적으로 객체 생성")
    void givenPositiveNumber_whenCreating_thenSuccess() {
        NaturalNumber number = NaturalNumber.of(5);
        assertThat(number.getNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("0 이하의 숫자를 입력하면 예외 발생")
    void givenZeroOrNegative_whenCreating_thenThrowsException() {
        assertThatThrownBy(() -> NaturalNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_NUMBER_OF_POSITION.getErrorMessage());
    }
}