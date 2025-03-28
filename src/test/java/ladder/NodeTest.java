package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class NodeTest {

    @Test
    @DisplayName("오른쪽 방향 위치 이동 확인")
    void testMoveRightDirection() {
        Node node = Node.from(RIGHT);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("방향 없음(NONE) 위치 이동 확인")
    void testMoveNoneDirection() {
        Node node = Node.from(NONE);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 방향 위치 이동 확인")
    void testMoveLeftDirection() {
        Node node = Node.from(LEFT);

        Position position = Position.from(1);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({
            "RIGHT, 0, 1",
            "NONE, 0, 0",
            "LEFT, 1, 0"
    })
    @DisplayName("방향에 따라 위치 이동 확인 (ParameterizedTest 적용)")
    void testMoveDirection(Direction direction, int start, int expectedResult) {
        Node node = Node.from(direction);

        Position position = Position.from(start);
        node.move(position);

        assertThat(position.getValue()).isEqualTo(expectedResult);
    }

}