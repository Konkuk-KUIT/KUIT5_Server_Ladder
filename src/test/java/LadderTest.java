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
}