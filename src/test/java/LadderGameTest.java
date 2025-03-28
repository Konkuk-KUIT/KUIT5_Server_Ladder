import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("drawLine_테스트")
    void drawLineTest() {
        // given
        LadderGame ladderGame = LadderGameFactory.createDefaultLadderGame(4, 5);
        LadderCreator ladder = ladderGame.getLadderCreator();

        // when
        ladder.drawLine(Position.of(2), Position.of(2));

        // then
        assertEquals(Direction.RIGHT, ladder.getState(Position.of(2), Position.of(2)));
        assertEquals(Direction.LEFT, ladder.getState(Position.of(2), Position.of(3)));
    }

    @Test
    @DisplayName("run_테스트_선이없는경우")
    void runTest_NoLines() {
        // given
        LadderGame ladderGame = LadderGameFactory.createDefaultLadderGame(4, 5);
        LadderRunner runner = LadderRunner.of(ladderGame.getLadderCreator());

        // when
        int finalPosition = runner.run(2);

        // then
        assertEquals(2, finalPosition);
    }

    @Test
    @DisplayName("run_테스트_선이있는경우")
    void runTest_WithLines() {
        // given
        LadderGame ladderGame = LadderGameFactory.createDefaultLadderGame(4, 5);
        LadderCreator ladder = ladderGame.getLadderCreator();
        LadderRunner runner = LadderRunner.of(ladder);

        ladder.drawLine(Position.of(0), Position.of(2));
        ladder.drawLine(Position.of(2), Position.of(3));

        // when
        int finalPosition = runner.run(2);

        // then
        assertEquals(4, finalPosition);
    }

    @Test
    @DisplayName("run_테스트_잘못된시작위치")
    void runTest_InvalidStart() {
        // given
        LadderGame ladderGame = LadderGameFactory.createDefaultLadderGame(4, 5);
        LadderRunner runner = LadderRunner.of(ladderGame.getLadderCreator());

        // when & then
        assertThrows(IllegalArgumentException.class, () -> runner.run(-1));
        assertThrows(IllegalArgumentException.class, () -> runner.run(5));
    }
}
