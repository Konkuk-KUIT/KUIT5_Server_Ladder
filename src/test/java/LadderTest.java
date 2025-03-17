import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리가 잘 초기화되는지 확인")
    void testLadderInitialize() {
        Ladder ladder =new Ladder(new NaturalNumber(3),new NaturalNumber(2));
        assertNotNull(ladder);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-2,-15})
    @DisplayName("자연수가 아닐 때는 생성이 되지 않는다.")
    void throwExceptionWhenNotNaturalNumber(int givenNumbers) {
        String expectedErrorMessage="자연수가 아닙니다.";
        Assertions.assertThatThrownBy(()->new NaturalNumber(givenNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @Test
    @DisplayName("사다리에 선이 잘 생성되는 지 확인")
    void testMakeLadderLine(){
        Ladder ladder =new Ladder(new NaturalNumber(3),new NaturalNumber(5));
        ladder.drawLine(new NaturalNumber(2),new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(2),new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3),new NaturalNumber(3));
        ladder.drawLine(new NaturalNumber(3),new NaturalNumber(5));
    }

    @Test
    @DisplayName("연속된 선 만들면 오류 발생")
    void throwExceptionWhenMakeContinuousLine(){
        Ladder ladder =new Ladder(new NaturalNumber(3),new NaturalNumber(5));
        Assertions.assertThatThrownBy(()->{
            ladder.drawLine(new NaturalNumber(1),new NaturalNumber(1));
            ladder.drawLine(new NaturalNumber(1),new NaturalNumber(2));
            ladder.drawLine(new NaturalNumber(1),new NaturalNumber(3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {6,7,8})
    @DisplayName("시작점 선택 시 사다리 범위를 벗어나면 오류 발생하는지 확인")
    void throwExceptionWhenCheckValidPosition(int givenNumbers){
        int[][] rows=new int[3][5];
        ValidationPosition validationPosition=new ValidationPosition(rows);
        Assertions.assertThatThrownBy(()->validationPosition.checkValidPostion((givenNumbers)))
                        .isInstanceOf(IndexOutOfBoundsException.class);
    }

}