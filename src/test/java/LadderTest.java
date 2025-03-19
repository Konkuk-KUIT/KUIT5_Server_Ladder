import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {8, 12, 41})
    @DisplayName("사다리 그리기 - 잘못된 라인 선택")
    void testDrawLineWhenSelectedWrongLine(int selectedLine){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(selectedLine, 1));
        assertEquals(ExceptionMessage.INVALID_DRAW_LINE.getMessage(), exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("사다리 그리기 - 잘못된 라인 선택(음수)")
    void testDrawLineWithNotNaturalNumberLine(int selectedLine){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(selectedLine, 1));
        assertEquals(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 100})
    @DisplayName("사다리 그리기 - 잘못된 높이 선택")
    void testDrawLineWhenSelectedLineIsOutOfRange(int selectedLevel){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, selectedLevel));
        assertEquals(ExceptionMessage.INVALID_DRAW_LEVEL.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("사다리 그리기 - 잘못된 높이 선택(음수)")
    void testDrawLineWithNotNaturalNumberLevel(int selectedLevel){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, selectedLevel));
        assertEquals(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 왼쪽이 선점된 선택")
    void testDrawLineWhenSelectedLineIsNotAvailableAtLeft(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(1, 1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 1));
        assertEquals(ExceptionMessage.ALREADY_EXIST_POSITION.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 오른쪽이 선점된 선택")
    void testDrawLineWhenSelectedLineIsNotAvailableAtRight(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(3, 1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 1));
        assertEquals(ExceptionMessage.ALREADY_EXIST_POSITION.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 10})
    @DisplayName("사다리 타기 - 잘못된 라인 선택")
    void testRunWhenSelectedLineIsOutOfRange(int selectedLine) {
        int givenRow = 4, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(1,1);
        ladder.drawLine(4,1);
        ladder.drawLine(2,2);
        ladder.drawLine(4,2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.run(selectedLine));
        assertEquals(ExceptionMessage.INVALID_RUN_LINE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("사다리 타기 - 정상 작동")
    void testRun(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(1,1);
        ladder.drawLine(4,1);
        ladder.drawLine(2,2);
        ladder.drawLine(4,2);
        ladder.drawLine(3,3);
        ladder.drawLine(2,4);
        ladder.drawLine(4,4);
        ladder.drawLine(1,5);
        ladder.drawLine(4,6);
        ladder.drawLine(3,7);
        ladder.drawLine(1,7);
        ladder.drawLine(1,8);
        ladder.drawLine(3,8);

        assertEquals(4, ladder.run(1));
        assertEquals(2, ladder.run(2));
        assertEquals(3, ladder.run(3));
        assertEquals(1, ladder.run(4));
        assertEquals(5, ladder.run(5));
    }
}