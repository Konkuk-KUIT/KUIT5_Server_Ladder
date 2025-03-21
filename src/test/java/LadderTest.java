import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("drawLine_테스트")
    void drawLineTest(){
        //given
        Ladder ladder=new Ladder(4,5);

        //when
        ladder.drawLine(Position.of(2), Position.of(2));

        // then
        assertEquals(Direction.RIGHT, ladder.getState(Position.of(2), Position.of(2)));
        assertEquals(Direction.LEFT, ladder.getState(Position.of(2), Position.of(3)));
    }


    @Test
    @DisplayName("run_테스트_선이없는경우")
    void runTest_NoLines(){
        // given
        Ladder ladder = new Ladder(4, 5);

        // when
        int finalPosition = ladder.run(2);

        // then
        assertEquals(2, finalPosition);
    }

    @Test
    @DisplayName("run_테스트_선이있는경우")
    void runTest_WithLines(){
        // given
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(Position.of(0), Position.of(2));
        ladder.drawLine(Position.of(2), Position.of(3));

        // when
        int finalPosition = ladder.run(2);

        // then
        assertEquals(4, finalPosition);
    }

    @Test
    @DisplayName("run_테스트_잘못된시작위치")
    void runTest_InvalidStart(){
        // given
        Ladder ladder = new Ladder(4, 5);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> ladder.run(-1));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(5));
    }

}