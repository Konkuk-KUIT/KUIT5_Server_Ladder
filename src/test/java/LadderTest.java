import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        // given
        Ladder ladder = new Ladder(5, 4);

        // when & then
        assertThat(ladder.getRows().length).isEqualTo(5);
        assertThat(ladder.getRows()[0].length).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 생성 실패")
    void createLadderFail() {
        // given & when & then
        assertThatThrownBy(() -> new Ladder(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid number");
    }

    @Test
    @DisplayName("사다리 라인 생성")
    void createLine() {
        //  given
        Ladder ladder = new Ladder(4, 4);
        ladder.init(4);
        Position position = Position.of(1, 1);

        // when
        ladder.drawLine(position);

        // then
        assertThat(ladder.getRows()[0][0]).isEqualTo(1);
        assertThat(ladder.getRows()[0][1]).isEqualTo(-1);
    }

    @Test
    @DisplayName("사다리 타기")
    void runTheLadder() {
        //  given
        Ladder ladder = new Ladder(4, 4);
        ladder.init(4);
        ladder.drawLine(Position.of(1, 1));
        ladder.drawLine(Position.of(2, 1));
        ladder.drawLine(Position.of(3, 2));
        ladder.drawLine(Position.of(4, 3));
        ladder.drawLine(Position.of(1, 3));

        // when
        int result = ladder.run(2);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 연결 검증(연속적으로 연결된 사다리)")
    void verifyLadder1_1() {
        //  given
        Ladder ladder = new Ladder(4, 4);
        ladder.init(4);
        ladder.drawLine(Position.of(1, 1));

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(Position.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 사다리가 있습니다.");
    }

    @Test
    @DisplayName("사다리 연결 검증(연속적으로 연결된 사다리2)")
    void verifyLadder1_2() {
        //  given
        Ladder ladder = new Ladder(4, 4);
        ladder.init(4);
        ladder.drawLine(Position.of(1, 3));

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(Position.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 사다리가 있습니다.");
    }

    @Test
    @DisplayName("사다리 연결 검증(사다리의 높이 보다 높은 위치)")
    void verifyLadder2() {
        //  given
        Ladder ladder = new Ladder(4, 4);
        ladder.init(4);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(Position.of(5, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이보다 높은 위치입니다.");
    }

    @Test
    @DisplayName("사다리 연결 검증(잘못된 사다리 번호)")
    void verifyLadder3() {
        //  given
        Ladder ladder = new Ladder(4, 4);
        ladder.init(4);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(Position.of(2, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사다리 번호입니다.");
    }

}