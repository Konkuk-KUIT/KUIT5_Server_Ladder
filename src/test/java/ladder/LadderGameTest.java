package ladder;

import ladder.creator.BasicLadderCreator;
import ladder.creator.LadderGameFactory;
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
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);

        //when
        BasicLadderCreator ladderCreator = new BasicLadderCreator(ladderSize);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        BasicLadderCreator ladderCreator = new BasicLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

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
        LadderSize ladderSize = new LadderSize(row, numberOfPerson);
        BasicLadderCreator ladderCreator = new BasicLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0),Position.from(0));
        ladderCreator.drawLine(Position.from(1),Position.from(1));
        ladderCreator.drawLine(Position.from(2),Position.from(0));

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
        LadderSize ladderSize = new LadderSize(row, numberOfPerson);
        BasicLadderCreator ladderCreator = new BasicLadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        ladderCreator.drawLine(Position.from(0), Position.from(0));
        ladderCreator.drawLine(Position.from(1), Position.from(1));
        ladderCreator.drawLine(Position.from(2), Position.from(0));

        //given
        Position position = Position.from(input);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4",
            "5, 5",
            "6, 4"
    })
    @DisplayName("사다리 자동 생성 확인")
    void testRandomLadder(int row, int col) {
        GreaterThanOne numberOfRow = GreaterThanOne.from(row);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(col);
        LadderSize ladderSize = new LadderSize(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        ladderGame.printLadder("< "+row+"x"+col+" >");
    }

}