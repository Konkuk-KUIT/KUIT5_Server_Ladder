package ladder.creator;

import ladder.GreaterThanOne;
import ladder.game.LadderGame;
import ladder.position.Position;
import ladder.game.LadderGameFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

class RandomLadderCreatorTest {

    @ParameterizedTest
    @CsvSource(value = {"5,4", "3,3", "10,6"})
    @DisplayName("랜덤 사다리 생성 결과가 정상적으로 출력되는지 확인한다")
    void drawRandomLadderTest(int rowData, int colData) {
        // given
        GreaterThanOne row = GreaterThanOne.from(rowData);
        GreaterThanOne column = GreaterThanOne.from(colData);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(row, column);

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(randomLadderCreator);

        HashSet<Integer> result = new HashSet<>();
        // when
        for (int i = 0; i < colData; i++) {
            result.add(ladderGame.run(Position.from(i)));
        }

        // then
        assertThat(result).hasSize(colData);

    }
}