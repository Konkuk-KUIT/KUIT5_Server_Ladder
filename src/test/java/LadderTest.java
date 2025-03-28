import exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사다리 정상 생성 확인")
    void testLadderCreation() {
        //given
        NaturalNumber row = NaturalNumber.of(5);
        NaturalNumber numberOfPerson = NaturalNumber.of(4);

        // when
        Ladder ladder = Ladder.from(row, numberOfPerson);

        // then
        assertThat(ladder.getRow()).isEqualTo(5);
        assertThat(ladder.getCol()).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "3,3",
            "4,4"
    })
    @DisplayName("사다리 가로선 X - 정상 실행 확인")
    void testRunLadderWithoutLine(int input, int result) {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderRunner runner = LadderRunner.from();

        // when
        NaturalNumber startPosition = NaturalNumber.of(input);

        // then
        assertThat(runner.run(ladder, startPosition)).isEqualTo(result);
    }

    @Test
    @DisplayName("사다리 가로선 추가 - 정상 생성 확인")
    void testDrawLine() {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderCreator creator = LadderCreator.from();

        // when
        creator.drawLine(ladder, Position.of(0, 0));

        // then
        assertThat(ladder.getLadderState(0, 0)).isEqualTo(Direction.RIGHT.getValue());
        assertThat(ladder.getLadderState(0, 1)).isEqualTo(Direction.LEFT.getValue());
    }

    @ParameterizedTest
    @CsvSource({
            "1,4",
            "2,1",
            "3,2",
            "4,3"
    })
    @DisplayName("사다리 가로선 추가 - 정상 실행 확인")
    void testRunLadder(int input, int result) {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderCreator creator = LadderCreator.from();
        LadderRunner runner = LadderRunner.from();
        creator.drawLine(ladder, Position.of(0, 0));
        creator.drawLine(ladder, Position.of(1, 1));
        creator.drawLine(ladder, Position.of(2, 2));

        // when
        NaturalNumber startPosition = NaturalNumber.of(input);

        // then
        assertThat(runner.run(ladder, startPosition)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1,4",
            "2,1",
            "3,2",
            "4,3"
    })
    @DisplayName("사다리 가로선 추가 - 정상 실행 & 출력 확인")
    void testRunLadderPrinter(int input, int result) {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderCreator creator = LadderCreator.from();
        LadderRunnerWithPrinter runner = LadderRunnerWithPrinter.from(LadderPrinter.of(ladder.getRows()));
        creator.drawLine(ladder, Position.of(0, 0));
        creator.drawLine(ladder, Position.of(1, 1));
        creator.drawLine(ladder, Position.of(2, 2));

        // when
        NaturalNumber startPosition = NaturalNumber.of(input);

        // then
        assertThat(runner.run(ladder, startPosition)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "-1, 2",
            "5, 1"
    })
    @DisplayName("예외 발생 - 유효하지 않은 위치")
    void testDrawLineInvalidPosition(int x, int y) {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderCreator creator = LadderCreator.from();

        // when & then
        assertThatThrownBy(() -> creator.drawLine(ladder, Position.of(x, y)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_POSITION.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 2"
    })
    @DisplayName("예외 발생 - 이미 선이 있는 위치")
    void testDrawLineAlreadyExists(int x, int y) {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderCreator creator = LadderCreator.from();

        // when
        creator.drawLine(ladder, Position.of(x, y));

        // then
        assertThatThrownBy(() -> creator.drawLine(ladder, Position.of(x, y)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ALREADY_HAS_LINE.getMessage());
    }

    @Test
    @DisplayName("예외 발생 - 잘못된 출발 위치")
    void testRunLadderInvalidStart() {
        // given
        Ladder ladder = Ladder.from(NaturalNumber.of(5), NaturalNumber.of(4));
        LadderRunner runner = LadderRunner.from();

        // when & then
        assertThatThrownBy(() -> runner.run(ladder, NaturalNumber.of(5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_START_POSITION.getMessage());
    }

    @Test
    @DisplayName("랜덤 사다리 자동 생성 테스트")
    void testRandomLadderGeneration() {
        // given
        NaturalNumber row = NaturalNumber.of(5);
        NaturalNumber col = NaturalNumber.of(4);
        LadderGame game = LadderGameFactory.createRandomLadderGame(row, col);
        int[][] rows = game.getLadderState();

        // when
        int count = 0;
        for (int[] r : rows) {
            for (int val : r) {
                if (val != 0) count++;
            }
        }

        // then
        int expected = (int)(row.getValue() * col.getValue() * 0.3) * 2;
        assertThat(count).isGreaterThanOrEqualTo(expected - 2);
    }

    @Test
    @DisplayName("게임 플레이 테스트")
    void testLadderGamePlay() {
        // given
        NaturalNumber row = NaturalNumber.of(5);
        NaturalNumber col = NaturalNumber.of(4);
        LadderGame game = LadderGameFactory.createManualLadderGame(row, col);

        // when
        int result = game.play(NaturalNumber.of(1));

        // then
        assertThat(result).isEqualTo(1);
    }
}