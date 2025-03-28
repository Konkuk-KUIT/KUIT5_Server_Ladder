package ladder;

import ladder.creator.LadderBasicCreator;
import ladder.creator.LadderCreator;
import ladder.creator.LadderRandomCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderBasicCreator ladderBasicCreator = new LadderBasicCreator(new LadderSize(numberOfRow, numberOfPerson));

        //then
        assertThat(ladderBasicCreator).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderGame ladderGame = LadderGameFactory.createLadderGame(new LadderSize(GreaterThanOne.from(2), numberOfPerson));

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderBasicCreator ladderBasicCreator = new LadderBasicCreator(new LadderSize(row, numberOfPerson));
        LadderGame ladderGame = new LadderGame(ladderBasicCreator);

        ladderBasicCreator.drawLine(Position.from(0),Position.from(0));
        ladderBasicCreator.drawLine(Position.from(1),Position.from(1));
        ladderBasicCreator.drawLine(Position.from(2),Position.from(0));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2",
            "1, 1",
            "2, 0"
    })
    @DisplayName("사다리 결과 확인 (ParameterizedTest 적용)")
    void testLadderResult(int input, int expectedResult) {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderBasicCreator ladderBasicCreator = new LadderBasicCreator(new LadderSize(row, numberOfPerson));
        LadderGame ladderGame = new LadderGame(ladderBasicCreator);

        ladderBasicCreator.drawLine(Position.from(0), Position.from(0));
        ladderBasicCreator.drawLine(Position.from(1), Position.from(1));
        ladderBasicCreator.drawLine(Position.from(2), Position.from(0));

        //given
        Position position = Position.from(input);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("랜덤 사다리 생성 확인")
    void testRandomCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderCreator ladderRandomCreator = new LadderRandomCreator(new LadderSize(numberOfRow, numberOfPerson));

        //then
        assertThat(ladderRandomCreator).isNotNull();
    }

    @Test
    @DisplayName("랜덤 사다리 게임 생성 확인")
    void testRandomCreateLadderGame() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        LadderGame randomLadderGame = LadderGameFactory.createRandomLadderGame(new LadderSize(numberOfRow, numberOfPerson));

        //then
        assertThat(randomLadderGame).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5, 0", //line count 4
            "3, 3, 0", //line count 2
            "6, 5, 0" //line count 9
    })
    @DisplayName("랜덤 사다리 게임 실행 확인 (사다리 출력 확인용, 무조건 성공)")
    void testRandomCreateLadderGameRun(int row, int col, int position) {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(row);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(col);
        LadderGame randomLadderGame = LadderGameFactory.createRandomLadderGame(new LadderSize(numberOfRow, numberOfPerson));

        //when
        randomLadderGame.run(Position.from(position));

        //then
        assertThat(randomLadderGame).isNotNull();
    }
}