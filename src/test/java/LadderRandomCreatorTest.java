import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderRandomCreatorTest {
    @ParameterizedTest
    @CsvSource({
            "2,3",
            "3,3",
            "14,23"
    })
    @DisplayName("LadderRandomCreator의 createRandomLadderGame은 정상적으로 객체를 반환하는지")
    void testCreatorReturnsInstance(int row, int numberOfPerson) {
        // given
        Ladder ladder = new Ladder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson));

        // when
        LadderRandomCreator creator = LadderRandomCreator.createRandomLadderGame(ladder);

        // then
        assertThat(creator).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({
            "3,3,2",
            "3,4,3",
            "4,4,4",
    })
    @DisplayName("랜덤 사다리를 생성할 때 생성되는 라인 수가 정확한지")
    void testCorrectLineCount(int row, int numberOfPerson, int expectedResult){
        // given
        Ladder ladder = new Ladder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson));

        // when: 랜덤으로 사다리 선을 생성하고, RIGHT 방향 개수를 카운트
        ladder.createRandomLadderGame();
        int[][] rows = ladder.getLadderRows().getRows();
        int count = 0;
        for (int[] currentRow : rows) {
            for (int cell : currentRow) {
                if (cell == Direction.RIGHT.getValue()) {
                    count++;
                }
            }
        }

        // then
        assertThat(count).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "3,3,2",
            "2,4,2",
            "4,5,3",
    })
    @DisplayName("랜덤으로 생성된 사다리에서 run 실행 시 예외 없이 결과가 반환된다")
    void testRandomLadderGameRun(int row, int numberOfPerson, int start) {
        // given: 3행 3명의 사다리를 생성하고 랜덤 선을 그림
        Ladder ladder = new Ladder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson));
        ladder.createRandomLadderGame();
        LadderGame ladderGame = LadderGame.of(ladder);
        NaturalNumber startPosition = NaturalNumber.of(start);

        // when: 게임을 실행함
        int result = ladderGame.run(startPosition);

        // then: 반환된 결과는 1 ~ 3 사이의 값이어야 함 (사람 수 기준)
        assertThat(result)
                .as("사다리 게임 실행 결과는 유효한 위치여야 한다")
                .isBetween(1, numberOfPerson);
    }
}