package ladder;

import ladder.creator.LadderCreator;
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
        LadderCreator ladderCreator = new LadderCreator(LadderSize.of(numberOfRow, numberOfPerson));

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        LadderCreator ladderCreator = new LadderCreator(ladderSize);
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
        GreaterThanOne row = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);

        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        LadderPosition ladderPosition1 = LadderPosition.of(Position.from(0), Position.from(0));
        LadderPosition ladderPosition2 = LadderPosition.of(Position.from(1), Position.from(1));
        LadderPosition ladderPosition3 = LadderPosition.of(Position.from(2), Position.from(0));

        ladderCreator.drawLine(ladderPosition1);
        ladderCreator.drawLine(ladderPosition2);
        ladderCreator.drawLine(ladderPosition3);

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
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);

        LadderCreator ladderCreator = new LadderCreator(ladderSize);
        LadderGame ladderGame = new LadderGame(ladderCreator);

        LadderPosition ladderPosition1 = LadderPosition.of(Position.from(0), Position.from(0));
        LadderPosition ladderPosition2 = LadderPosition.of(Position.from(1), Position.from(1));
        LadderPosition ladderPosition3 = LadderPosition.of(Position.from(2), Position.from(0));

        ladderCreator.drawLine(ladderPosition1);
        ladderCreator.drawLine(ladderPosition2);
        ladderCreator.drawLine(ladderPosition3);

        //given
        Position position = Position.from(input);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

}