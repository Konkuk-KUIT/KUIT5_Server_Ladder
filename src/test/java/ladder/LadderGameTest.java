package ladder;

import ladder.creator.LadderGenerator;
import ladder.creator.ManualLadderCreator;
import ladder.creator.RandomLadderCreator;
import ladder.game.LadderGame;
import ladder.game.LadderGameFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateManualLadder() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        // when
        LadderGame game = LadderGameFactory.createManualLadderGame(numberOfRow, numberOfPerson);

        // then
        assertThat(game).isNotNull();
    }


    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        // given
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(numberOfRow, numberOfPerson);

        // when
        Position invalidPosition = Position.from(4);

        // then
        assertThatThrownBy(() -> ladderGame.run(invalidPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }


    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.from(0),Position.from(0));
        manualLadderCreator.drawLine(Position.from(1),Position.from(1));
        manualLadderCreator.drawLine(Position.from(2),Position.from(0));

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
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.from(0), Position.from(0));
        manualLadderCreator.drawLine(Position.from(1), Position.from(1));
        manualLadderCreator.drawLine(Position.from(2), Position.from(0));

        //given
        Position position = Position.from(input);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2"
    })
    @DisplayName("사다리 출력 확인 기본 테스트")
    void testLadderPrinterBasic(int input, int expectedResult) {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.from(0), Position.from(0));
        manualLadderCreator.drawLine(Position.from(1), Position.from(1));
        manualLadderCreator.drawLine(Position.from(2), Position.from(0));

        //given
        Position position = Position.from(input);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 0",
            "2, 2"
    })
    @DisplayName("다양한 사다리 이동 경로에 따른 출력 테스트")
    void testLadderPrinterVariousRoutes(int input, int expectedResult) {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.from(0), Position.from(0));
        manualLadderCreator.drawLine(Position.from(1), Position.from(1));
        manualLadderCreator.drawLine(Position.from(2), Position.from(1));

        Position position = Position.from(input);
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 2",
            "3, 3"
    })
    @DisplayName("사다리에 line이 없을 때의 출력 테스트")
    void testLadderPrinterWithNoLines(int input, int expectedResult) {
        // given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(row, numberOfPerson);

        // when
        Position position = Position.from(input);

        // then
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 0"
    })
    @DisplayName("오른쪽 끝에서 시작해 왼쪽으로 이동하는 경로 출력 테스트")
    void testStartFromLastPosition(int input, int expectedResult) {
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        ManualLadderCreator manualLadderCreator = new ManualLadderCreator(row, numberOfPerson);
        LadderGame ladderGame = new LadderGame(manualLadderCreator);

        manualLadderCreator.drawLine(Position.from(0), Position.from(2));
        manualLadderCreator.drawLine(Position.from(1), Position.from(1));
        manualLadderCreator.drawLine(Position.from(2), Position.from(0));

        Position position = Position.from(input);
        assertThat(ladderGame.run(position)).isEqualTo(expectedResult);
    }

    @RepeatedTest(3) // 랜덤성을 위해 여러번 실행
    @DisplayName("자동 생성된 사다리에서 시작 위치 결과가 유효 범위 내에 있는지 테스트")
    void testRandomLadderGameUsingFactory() {
        GreaterThanOne row = GreaterThanOne.from(5);
        GreaterThanOne person = GreaterThanOne.from(4);

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(row, person);

        int start = 0;
        int result = ladderGame.run(Position.from(start));

        assertThat(result)
                .isGreaterThanOrEqualTo(0)
                .isLessThan(person.getNumber()); // 결과는 0 이상 사람수 미만
    }
}