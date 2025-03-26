import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderDrawLineTest {
    @ParameterizedTest
    @ValueSource(ints = {8, 12, 41})
    @DisplayName("사다리 그리기 - 잘못된 라인 선택")
    void testDrawLineWhenSelectedWrongLine(int selectedLine){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        assertThatThrownBy(() -> ladder.drawLine(selectedLine, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
    }
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("사다리 그리기 - 잘못된 라인 선택(음수, 0)")
    void testDrawLineWithNotNaturalNumberLine(int selectedLine){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        assertThatThrownBy(() -> ladder.drawLine(selectedLine, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_NATURAL_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 100})
    @DisplayName("사다리 그리기 - 잘못된 높이 선택")
    void testDrawLineWhenSelectedLineIsOutOfRange(int selectedLevel){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        assertThatThrownBy(() -> ladder.drawLine(1, selectedLevel)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0})
    @DisplayName("사다리 그리기 - 잘못된 높이 선택(음수, 0)")
    void testDrawLineWithNotNaturalNumberLevel(int selectedLevel){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);

        assertThatThrownBy(() -> ladder.drawLine(1, selectedLevel)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_NATURAL_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 왼쪽이 선점된 선택")
    void testDrawLineWhenSelectedLineIsNotAvailableAtLeft(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(1, 1);

        assertThatThrownBy(() -> ladder.drawLine(2, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 오른쪽이 선점된 선택")
    void testDrawLineWhenSelectedLineIsNotAvailableAtRight(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(3, 1);

        assertThatThrownBy(() -> ladder.drawLine(2, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_DRAW_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 - 이미 오른쪽이 선점된 선택")
    void testDrawLine(){
        int givenRow = 8, givenNumberOfPerson = 5;
        Ladder ladder = Ladder.create(givenRow, givenNumberOfPerson);
        ladder.drawLine(3, 1);

        ladder.drawLine(1, 1);
    }
}
