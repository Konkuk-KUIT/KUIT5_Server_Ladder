package ladderGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomLadderGameTest {

    @Test
    @DisplayName("Positive: 랜덤생성된 사다리의 개수는 [person * height * 0.3] 이어야 한다. (소수점 버림)")
    void shouldRandomLadderCountMatchingPersonTimesHeightTimes0_3() {
        // given
        final int person = 5;
        final int height = 4;
        final int numberOfLadderLine = person * height * 3 / 10;
        int countOfLadderLine = 0;

        RandomLadderGame randomLadderGameCreator = new RandomLadderGame();
        LadderGame ladderGame = randomLadderGameCreator.create(new LadderGame(height, person));
        for(int row = 1; row <= height; row++) {
            for(int column = 1; column < person; column++) {
                if (ladderGame.hasLine(new Position(row, column, height, person))) {
                    countOfLadderLine++;

                }
            }
        }

        // when & then
        assertThat(countOfLadderLine).isEqualTo(numberOfLadderLine);

    }


    @Test
    @DisplayName("Negative: 인원이 1명일 때 랜덤생성은 불가능하다.")
    void shouldThrowExceptionWhenOnePlayer() {
        // given
        final int person = 1;
        final int height = 10;

        // when & then
        assertThatThrownBy(() -> LadderGameFactory.createRandomLadderGame(height, person))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionCode.NO_SOLO_RANDOM_LADDER.getMessage());
    }
}