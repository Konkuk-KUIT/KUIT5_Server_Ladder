import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 2",
            "3, 3"
    })
    @DisplayName("줄이 없는 경우는 그대로 내려감")
    void runWithoutLines(int input, int expected) {
        // given
        Ladder ladder = new Ladder(3, 4);

        // when
        int result = ladder.run(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("줄이 그어진 위치에서만 좌우 이동")
    void drawLineMoveLeftOrRight() {
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 1);

        // when
        int result1 = ladder.run(new Position(1).getIndex());
        int result2 = ladder.run(new Position(2).getIndex());
        int result3 = ladder.run(new Position(0).getIndex());

        // then
        assertThat(result1).isEqualTo(2); // 오른쪽 이동
        assertThat(result2).isEqualTo(1); // 왼쪽 이동
        assertThat(result3).isEqualTo(0); // 이동 없음
    }

    @Test
    @DisplayName("연속된 줄은 예외 발생")
    void drawLineException() {
        // given
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 1);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(0, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 선이 그어져 있거나 연속된 선입니다.");
    }

    @Test
    @DisplayName("마지막 열에는 선을 그을 수 없음")
    void drawLineCannotInLastCol() {
        // given
        Ladder ladder = new Ladder(3, 4);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사다리 위치입니다.");
    }

    @Test
    @DisplayName("범위를 벗어난 줄에 그릴 경우 예외 발생")
    void drawLineOutOfBoundsException() {
        // given
        Ladder ladder = new Ladder(3, 4);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(3, 0)) // row는 0~2까지
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사다리 위치입니다.");
    }


}