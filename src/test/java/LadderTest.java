import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 8, 12})
    @DisplayName("사다리 그리기 - 잘못된 라인 선택")
    void testDrawLineWhenSelectedWrongLine(int selectedLine){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = new Ladder(givenRow, givenNumberOfPerson);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(selectedLine, 1));
        assertEquals("선택된 라인과 그 오른편의 라인을 연결하므로 가장 끝 라인을 제외한 라인을 선택하세요.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 12, 100})
    @DisplayName("사다리 그리기 - 잘못된 높이 선택")
    void testDrawLineWhenSelectedLineIsOutOfRange(int selectedLevel){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = new Ladder(givenRow, givenNumberOfPerson);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, selectedLevel));
        assertEquals("가능한 높이를 벗어났습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 왼쪽이 선점된 선택")
    void testDrawLineWhenSelectedLineIsNotAvailableAtLeft(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = new Ladder(givenRow, givenNumberOfPerson);
        ladder.drawLine(1, 1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 1));
        assertEquals("이미 선점된 위치입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 오른쪽이 선점된 선택")
    void testDrawLineWhenSelectedLineIsNotAvailableAtRight(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = new Ladder(givenRow, givenNumberOfPerson);
        ladder.drawLine(3, 1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(2, 1));
        assertEquals("이미 선점된 위치입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("사다리 타기")
    void testRun(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = new Ladder(givenRow, givenNumberOfPerson);
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