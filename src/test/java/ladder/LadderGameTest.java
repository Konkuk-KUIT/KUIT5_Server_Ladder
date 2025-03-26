package ladder;

import ladder.core.LadderGame;
import ladder.core.LadderGameFactory;
import ladder.core.LadderSize;
import ladder.creator.LadderCreator;
import ladder.creator.LadderCreatorImpl;
import ladder.utils.GreaterThanOne;
import ladder.utils.position.LadderPosition;
import ladder.utils.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        LadderCreator ladderCreator = new LadderCreatorImpl(ladderSize);

        //then
        assertThat(ladderCreator).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.of(GreaterThanOne.from(2), numberOfPerson);

        LadderGame ladderGame = LadderGameFactory.createLadderGame(ladderSize);

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
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);

        LadderCreatorImpl ladderCreator = new LadderCreatorImpl(ladderSize);
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

        LadderCreator ladderCreator = new LadderCreatorImpl(ladderSize);
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

    @Test
    @DisplayName("사다리 자동 생성 확인")
    void testAutoCreateLadder() {
        //given
        GreaterThanOne row = GreaterThanOne.from(5);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(10);
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);

        //when
        LadderGame randomLadderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //then
        assertThat(randomLadderGame).isNotNull();
    }

    @Test
    @DisplayName("랜덤 사다리 결과 확인")
    void testRandomLadderResult() {
        //given
        GreaterThanOne row = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(row, numberOfPerson);
        LadderGame randomLadderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //when
        randomLadderGame.run(Position.from(3));

    }

}