import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LadderRunTest {
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
        assertThatThrownBy(() -> ladder.run(selectedLine)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALD_POSITION.getMessage());
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
