import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NaturalNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1,0})
    @DisplayName("0 이하의 숫자는 오류가 발생")
    void runWithLessThanOne(int input){
        Assertions.assertThatThrownBy(() ->
                new NaturalNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMsg.MORE_THAN_ZERO.getMessage());
    }


    @Test
    @DisplayName("자연수가 아닌 소수를 입력하는 오류 발생")
    void runWithFloatNum(){
        Assertions.assertThatThrownBy(() ->
                        new NaturalNumber(1.1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMsg.INPUT_CANNOT_DOUBLE_TYPE.getMessage());

    }
}