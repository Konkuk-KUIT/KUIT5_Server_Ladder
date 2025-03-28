import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameFactoryTest {

        @Test
        @DisplayName("RandomLadderGame이 올바르게 생성되는지")
        void createRandomLadderCreatorSuccessful() {
            LadderSize size = new LadderSize(new NaturalNumber(5), new NaturalNumber(4));

            LadderGame game = LadderGameFactory.createRandomLadderGame(size);

            assertThat(game).isNotNull();
        }

    @Test
    @DisplayName("랜덤 생성된 사다리가 정상적으로 실행이 되는지")
    void RunRandomLadderGameSuccessful() {
        // given
        LadderSize ladderSize = new LadderSize(new NaturalNumber(5), new NaturalNumber(4));
        LadderGame game = LadderGameFactory.createRandomLadderGame(ladderSize);

        // when
        game.startGame();
        int result = game.runGame(0);

        // then
        assertThat(result).isGreaterThanOrEqualTo(0).isLessThan(4);
    }

}