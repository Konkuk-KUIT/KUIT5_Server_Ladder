package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {

    @Test
    @DisplayName("한 칸 사다리 이동")
    void testOneStepLadderMovement() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.from(0);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("두 칸 사다리 선 이동")
    void testTwoStepLadderLineMovement() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //given
        Position position = Position.from(0);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(1);

        //given
        position = Position.from(1);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("세 칸 사다리 선 이동")
    void testThreeStepLadderLineMovement() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //given
        Position position = Position.from(0);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(1);

        //given
        position = Position.from(1);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(0);

        //given
        position = Position.from(2);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 0",
            "2, 2"
    })
    @DisplayName("세 칸 사다리 선 이동 (ParameterizedTest 적용)")
    void testThreeStepLadderLineMovement(int input, int expectedResult) {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //given
        Position position = Position.from(input);
        row.nextPosition(position);

        //then
        assertThat(position.getValue()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("사다리 선 없는 행 생성")
    void testGenerateRowWithoutLine() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        StringBuilder sb = new StringBuilder();

        //given
        Position position = Position.from(0);
        LadderPosition ladderPosition = LadderPosition.of(Position.from(1), Position.from(1));
        row.generateRow(sb, position, ladderPosition);

        //then
        assertThat(sb.toString()).isEqualTo("0 0 0 \n");
    }

    @Test
    @DisplayName("사다리 선 있는 행 생성")
    void testGenerateRowWithLine() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));
        StringBuilder sb = new StringBuilder();

        //given
        Position position = Position.from(0);
        LadderPosition ladderPosition = LadderPosition.of(Position.from(1), Position.from(1));
        row.generateRow(sb, position, ladderPosition);

        //then
        assertThat(sb.toString()).isEqualTo("1 -1 0 \n");
    }

    @Test
    @DisplayName("현재 노드가 포함된 행 생성")
    void testGenerateRowWithCurrentNode() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));
        StringBuilder sb = new StringBuilder();

        //given
        Position position = Position.from(0);
        LadderPosition ladderPosition = LadderPosition.of(Position.from(0), Position.from(0));
        row.generateRow(sb, position, ladderPosition);

        //then
        assertThat(sb.toString()).isEqualTo("1* -1 0 \n");
    }


    @Test
    @DisplayName("사다리 사람 수 예외 처리")
    void throwLadderPersonCountException() {
        assertThatThrownBy(() -> new Row(GreaterThanOne.from(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_NUMBER.getMessage());
    }

    @Test
    @DisplayName("사다리 최대 사람 수 초과 예외")
    void throwLadderExceedsMaxPersonCountException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.from(3);

        //then
        assertThatThrownBy(() -> row.nextPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 최소 사람 수 미만 예외")
    void throwLadderBelowMinPersonCountException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //then
        assertThatThrownBy(() -> row.nextPosition(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 초과 예외")
    void throwLadderDrawingPositionExceedsLimitException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.from(3);

        //then
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 미만 예외")
    void throwLadderDrawingPositionBelowLimitException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 좌측 선 중복 예외")
    void throwLadderDrawingLeftLineDuplicateException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 우측 선 중복 예외")
    void throwLadderDrawingRightLineDuplicateException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(1));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_POSITION.getMessage());
    }
}
