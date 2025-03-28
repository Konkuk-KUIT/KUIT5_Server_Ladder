package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {

    @Test
    @DisplayName("한 칸 사다리 이동")
    void testOneStepLadderMovement() {
        //when
        int numberOfPerson = 1;
        Row row = new Row(numberOfPerson);

        //given
        int position = 0;

        //then
        assertThat(row.nextPosition(position)).isEqualTo(0);
    }

    @Test
    @DisplayName("두 칸 사다리 선 이동")
    void testTwoStepLadderLineMovement() {
        //when
        int numberOfPerson = 2;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //given
        int position = 0;

        //then
        assertThat(row.nextPosition(position)).isEqualTo(1);

        //given
        position = 1;

        //then
        assertThat(row.nextPosition(position)).isEqualTo(0);
    }

    @Test
    @DisplayName("세 칸 사다리 선 이동")
    void testThreeStepLadderLineMovement() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //given
        int position = 0;

        //then
        assertThat(row.nextPosition(position)).isEqualTo(1);
        //given
        position = 1;

        //then
        assertThat(row.nextPosition(position)).isEqualTo(0);

        //given
        position = 2;

        //then
        assertThat(row.nextPosition(position)).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 사람 수 예외 처리")
    void throwLadderPersonCountException() {
        assertThatThrownBy(() -> new Row(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_NEGATIVE_ZERO.getMessage());
    }

    @Test
    @DisplayName("사다리 최대 사람 수 초과 예외")
    void throwLadderExceedsMaxPersonCountException() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = 3;

        //then
        assertThatThrownBy(() -> row.nextPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NO_OUTSIDE.getMessage());
    }

    @Test
    @DisplayName("유요하지 않은 위치 예외")
    void throwLadderBelowMinPersonCountException() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThatThrownBy(() -> row.nextPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_OUTSIDE.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 초과 예외")
    void throwLadderDrawingPositionExceedsLimitException() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = 3;

        //then
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CANTDRAWPOSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 미만 예외")
    void throwLadderDrawingPositionBelowLimitException() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CANTDRAWPOSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 좌측 선 중복 예외")
    void throwLadderDrawingLeftLineDuplicateException() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //then
        assertThatThrownBy(() -> row.drawLine(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CANTDRAWPOSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 우측 선 중복 예외")
    void throwLadderDrawingRightLineDuplicateException() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(1);

        //then
        assertThatThrownBy(() -> row.drawLine(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CANTDRAWPOSITION.getMessage());

    }
}
