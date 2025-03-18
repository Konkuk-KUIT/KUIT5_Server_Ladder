import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리가 잘 초기화되는지 확인")
    void testLadderInitialize() {
        Ladder ladder =new Ladder(NaturalNumber.of(3),NaturalNumber.of(2));
        assertNotNull(ladder);
    }

    @ParameterizedTest
    @CsvSource({
            "0,2",
            "-2,2",
            "2,-15"
    })
    @DisplayName("자연수가 아닐 때는 생성이 되지 않는다.")
    void throwExceptionWhenNotNaturalNumber(int row, int column) {
        String expectedErrorMessage="자연수가 아닙니다.";
        Assertions.assertThatThrownBy(()-> {
                    Ladder ladder = new Ladder(NaturalNumber.of(row), NaturalNumber.of(column));
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @Test
    @DisplayName("사다리에 선이 잘 생성되는 지 확인")
    void testMakeLadderLine(){
        Ladder ladder =new Ladder(NaturalNumber.of(3),NaturalNumber.of(5));
        ladder.drawLine(NaturalNumber.of(2),NaturalNumber.of(1));
        ladder.drawLine(NaturalNumber.of(2),NaturalNumber.of(3));
    }

    @Test
    @DisplayName("연속된 선 그리기 방지. 연속된 선을 그리려면 이미 라인이 그려진 위치여야 한다.")
    void throwExceptionWhenDrawLineContinuous(){
        Ladder ladder =new Ladder(NaturalNumber.of(6),NaturalNumber.of(5));
        Assertions.assertThatThrownBy(()->{
            ladder.drawLine(NaturalNumber.of(2),NaturalNumber.of(3));
            ladder.drawLine(NaturalNumber.of(2),NaturalNumber.of(4));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 라인이 그려진 위치입니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "3,6",
            "2,8",
            "4,3",
            "3,4"
    })
    @DisplayName("그릴 수 있는 범위를 초과한 것을 그리려고 할 때 오류 발생")
    void thowExceptionWhenNotPossibleDrawLine(int row, int column){
        Ladder ladder =new Ladder(NaturalNumber.of(3),NaturalNumber.of(4));
        Assertions.assertThatThrownBy(()->ladder.drawLine(NaturalNumber.of(row),NaturalNumber.of(column)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 위치입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {6,7,8})
    @DisplayName("시작점 선택 시 사다리 범위를 벗어나면 오류 발생하는지 확인")
    void throwExceptionWhenCheckValidPosition(int givenNumbers){
        int[][] rows=new int[3][5];
        Assertions.assertThatThrownBy(()->ValidationPosition.of(rows,givenNumbers))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("시작점이 존재하지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1,3",
            "2,2",
            "3,1",
    })
    @DisplayName("run 메서드가 잘 작동하는지")
    void testRunMethod(int input, int expected){
        Ladder ladder =new Ladder(NaturalNumber.of(3),NaturalNumber.of(3));
        ladder.drawLine(NaturalNumber.of(1),NaturalNumber.of(1));
        ladder.drawLine(NaturalNumber.of(2),NaturalNumber.of(2));
        ladder.drawLine(NaturalNumber.of(3),NaturalNumber.of(1));

        assertEquals(expected,ladder.run(NaturalNumber.of(input)));
    }


}