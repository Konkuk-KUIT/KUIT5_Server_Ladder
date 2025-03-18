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
        ladder.drawLine(new NaturalNumber(2),new NaturalNumber(3));
    }

    @Test
    @DisplayName("연속된 선 그리기 방지.")
    void throwExceptionWhenDrawLineContinuous(){
        Ladder ladder =new Ladder(new NaturalNumber(6),new NaturalNumber(5));
        Assertions.assertThatThrownBy(()->{
            ladder.drawLine(new NaturalNumber(2),new NaturalNumber(1));
            ladder.drawLine(new NaturalNumber(2),new NaturalNumber(4));
            ladder.drawLine(new NaturalNumber(2),new NaturalNumber(3));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이어지는 선을 그릴 수 없습니다.");
    }

    @Test
    @DisplayName("그릴 수 있는 범위를 초과한 것을 그리려고 할 때 오류 발생")
    void thowExceptionWhenNotPossibleDrawLine(){
        int row=3; int numberOfPerson=4;
        int [][]rows=new int[row+1][numberOfPerson+1];
        DrawPossible drawPossible = new DrawPossible(rows, row, numberOfPerson);
        Assertions.assertThatThrownBy(()->drawPossible.possibleAndDraw(2,4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 위치입니다.");
        Assertions.assertThatThrownBy(()->drawPossible.possibleAndDraw(2,5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 위치입니다.");
        Assertions.assertThatThrownBy(()->drawPossible.possibleAndDraw(4,3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 위치입니다.");
    }

    @Test
    @DisplayName("중복된 위치에 점을 그리려고 할 때 오류 발생")
    void thowExceptionWhenDuplicatedLineDraw(){
        int row=3; int numberOfPerson=4;
        int [][]rows=new int[row+1][numberOfPerson+1];
        DrawPossible drawPossible = new DrawPossible(rows, row, numberOfPerson);
        Assertions.assertThatThrownBy(()-> {
                    drawPossible.possibleAndDraw(1, 2);
                    drawPossible.possibleAndDraw(1,3);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 라인이 그려진 위치입니다.");
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

    @ParameterizedTest
    @CsvSource({
            "1,4",
            "2,2",
            "3,3",
            "4,1",
    })
    @DisplayName("run 메서드가 잘 작동하는지")
    void testRunMethod(int input, int expected){
        Ladder ladder =new Ladder(new NaturalNumber(5),new NaturalNumber(4));
        ladder.drawLine(new NaturalNumber(1),new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(1),new NaturalNumber(3));
        ladder.drawLine(new NaturalNumber(2),new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(3),new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(4),new NaturalNumber(3));

        assertEquals(expected,ladder.run(new NaturalNumber(input)));
//        assertEquals(4,ladder.run(new NaturalNumber(1)));
//        assertEquals(2,ladder.run(new NaturalNumber(2)));
//        assertEquals(3,ladder.run(new NaturalNumber(3)));
//        assertEquals(1,ladder.run(new NaturalNumber(4)));
    }


}