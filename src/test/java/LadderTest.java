import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void drawLineTest(){
        //given
        Ladder ladder=new Ladder(4,5);

        //when
        ladder.drawLine(Position.of(2), Position.of(2));

        // then
        assertEquals(1, ladder.getState(Position.of(2), Position.of(2)));
        assertEquals(-1, ladder.getState(Position.of(2), Position.of(3)));
    }
}