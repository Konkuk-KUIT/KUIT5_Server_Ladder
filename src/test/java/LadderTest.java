import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @DisplayName("빈 사다리에서 위치 그대로 도착")
    @ParameterizedTest
    @CsvSource({
            "0,0", "1,1", "2,2", "3,3"
    })
    void testLadderWithoutLine(int input, int expected) {
        // given
        Ladder ladder = new Ladder(3, 4);

        // when
        int result = ladder.run(input);

        // then
        assertThat(result).isEqualTo(expected);
    }


    @Test
    @DisplayName("사다리 라인 그리기 - 오른쪽/왼쪽 이동 확인")
    void testDrawLineAndRun() {
        // given
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 1); // 1번, 2번 연결

        // when & then
        assertThat(ladder.run(1)).isEqualTo(2); // 오른쪽
        assertThat(ladder.run(2)).isEqualTo(1); // 왼쪽
    }

    @Test
    @DisplayName("라인 연속 생성 시 예외 발생")
    void testDrawContinuousLinesException() {
        // given
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 1);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(0, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 선이 그어져 있거나 연속된 선입니다.");
    }

    @Test
    @DisplayName("마지막 열에는 선을 그을 수 없다")
    void testDrawLineAtLastColumnException() {
        // given
        Ladder ladder = new Ladder(3, 4);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사다리 위치입니다.");
    }

    @Test
    @DisplayName("라인 이동 방향 테스트")
    void testLineMove() {
        // given
        Line line = new Line(4);
        line.draw(1);
        Position p1 = new Position(1);
        Position p2 = new Position(2);

        // when
        line.move(p1);
        line.move(p2);

        // then
        assertThat(p1.getIndex()).isEqualTo(2);
        assertThat(p2.getIndex()).isEqualTo(1);
    }

}