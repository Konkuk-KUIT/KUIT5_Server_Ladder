/*package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {

    @Test
    @DisplayName("한 칸 사다리 이동")
    void testOneStepLadderMovement() {
        Row row = new Row(2);
        Position position =  new Position(0, 0);
        row.notify();
        assertThat(position.getClass()).isEqualTo(0);
    }

    @Test
    @DisplayName("두 칸 사다리 선 이동")
    void testTwoStepLadderLineMovement() {
        Row row = new Row(2);
        Position position =  new Position(0, 0);
        row.drawLine(new Position(0,0));

        row.nextPosition(position);
        assertThat(position.getValue()).isEqualTo(1);

        position = new Position(1, 0);
        row.nextPosition(position);
        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("세 칸 사다리 선 이동")
    void testThreeStepLadderLineMovement() {
        Row row = new Row(3);
        row.drawLine(new Position(0, 0));

        Position position = Position.from(0);
        row.nextPosition(position);
        assertThat(position.getValue()).isEqualTo(1);

        position = Position.from(1);
        row.nextPosition(position);
        assertThat(position.getValue()).isEqualTo(0);

        position = Position.from(2);
        row.nextPosition(position);
        assertThat(position.getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("사다리 최대 사람 수 초과 예외")
    void throwLadderExceedsMaxPersonCountException() {
        Row row = new Row(3);
        Position position = Position.from(3);
        assertThatThrownBy(() -> row.nextPosition(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 최소 사람 수 미만 예외")
    void throwLadderBelowMinPersonCountException() {
        Row row = new Row(3);
        assertThatThrownBy(() -> row.nextPosition(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 초과 예외")
    void throwLadderDrawingPositionExceedsLimitException() {
        Row row = new Row(3);
        int position = Position.from(3);
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 미만 예외")
    void throwLadderDrawingPositionBelowLimitException() {
        Row row = new Row(3);
        assertThatThrownBy(() -> row.drawLine(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LADDER_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 좌측 선 중복 예외")
    void throwLadderDrawingLeftLineDuplicateException() {
        Row row = new Row(3);
        row.drawLine(Position.from(0));
        assertThatThrownBy(() -> row.drawLine(Position.from(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 우측 선 중복 예외")
    void throwLadderDrawingRightLineDuplicateException() {
        Row row = new Row(3);
        row.drawLine(Position.from(1));
        assertThatThrownBy(() -> row.drawLine(Position.from(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_POSITION.getMessage());
    }
}*/

package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static ladder.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RowTest {
    @Test
    @DisplayName("한 칸 사다리 이동")
    void testOneStepLadderMovement() {
        // 기존 코드에서는 Row가 Position을 이동시키는 역할이 없음
        // 대신 Row의 get 메서드를 테스트
        Row row = new Row(2);
        assertThat(row.get(0)).isEqualTo(Direction.NONE.getValue());
        assertThat(row.get(1)).isEqualTo(Direction.NONE.getValue());
    }

    @Test
    @DisplayName("두 칸 사다리 선 이동")
    void testTwoStepLadderLineMovement() {
        // 기존 코드에서는 drawLine 메서드가 int y를 받음
        Row row = new Row(2);
        row.drawLine(0);

        // 선이 그려진 후 값 확인
        assertThat(row.get(0)).isEqualTo(Direction.RIGHT.getValue());
        assertThat(row.get(1)).isEqualTo(Direction.LEFT.getValue());
    }

    @Test
    @DisplayName("세 칸 사다리 선 이동")
    void testThreeStepLadderLineMovement() {
        Row row = new Row(3);
        row.drawLine(0);

        // 선이 그려진 후 값 확인
        assertThat(row.get(0)).isEqualTo(Direction.RIGHT.getValue());
        assertThat(row.get(1)).isEqualTo(Direction.LEFT.getValue());
        assertThat(row.get(2)).isEqualTo(Direction.NONE.getValue());
    }

    @Test
    @DisplayName("사다리 최대 사람 수 초과 예외")
    void throwLadderExceedsMaxPersonCountException() {
        Row row = new Row(3);
        // 범위를 벗어난 인덱스 접근 시 예외 발생 테스트
        assertThatThrownBy(() -> row.get(3))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("사다리 최소 사람 수 미만 예외")
    void throwLadderBelowMinPersonCountException() {
        Row row = new Row(3);
        // 범위를 벗어난 인덱스 접근 시 예외 발생 테스트
        assertThatThrownBy(() -> row.get(-1))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("사다리 그리기 위치 초과 예외")
    void throwLadderDrawingPositionExceedsLimitException() {
        Row row = new Row(3);
        // 범위를 벗어난 위치에 선 그리기 시도 시 예외 발생 테스트
        assertThatThrownBy(() -> row.drawLine(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 위치 미만 예외")
    void throwLadderDrawingPositionBelowLimitException() {
        Row row = new Row(3);
        // 범위를 벗어난 위치에 선 그리기 시도 시 예외 발생 테스트
        assertThatThrownBy(() -> row.drawLine(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 좌측 선 중복 예외")
    void throwLadderDrawingLeftLineDuplicateException() {
        Row row = new Row(3);
        row.drawLine(0);
        // 이미 선이 그려진 위치에 다시 그리기 시도 시 예외 발생 테스트
        assertThatThrownBy(() -> row.drawLine(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 그리기 우측 선 중복 예외")
    void throwLadderDrawingRightLineDuplicateException() {
        Row row = new Row(3);
        row.drawLine(0);
        // 이미 선이 그려진 위치에 다시 그리기 시도 시 예외 발생 테스트
        assertThatThrownBy(() -> row.drawLine(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_DRAW_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 길이 확인")
    void testRowLength() {
        Row row = new Row(5);
        assertThat(row.length()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 그리기 표시 확인")
    void testDrawMethod() {
        Row row = new Row(3);
        row.drawLine(0);

        // 현재 위치 표시 확인
        assertThat(row.draw(0, 0)).isEqualTo(Direction.RIGHT.getValue() + "*");
        // 일반 위치 표시 확인
        assertThat(row.draw(1, 0)).isEqualTo(String.valueOf(Direction.LEFT.getValue()));
        assertThat(row.draw(2, 0)).isEqualTo(String.valueOf(Direction.NONE.getValue()));
    }
}

