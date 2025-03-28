import creator.LadderCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Direction;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLadderCreatorTest {
    @Test
    @DisplayName("수동으로 사다리를 생성할 때 사다리가 올바른 위치에 선을 제대로 그리는가")
    void DrawManualLadderSuccessful() {
        // given
        LadderSize ladderSize = new LadderSize(new NaturalNumber(3), new NaturalNumber(4));
        Ladder ladder = new Ladder(ladderSize);
        LadderCreator creator = new ManualLadderCreator(ladder);

        // when
        creator.drawLine();

        // then
        Direction[][] rows = ladder.getRows();

        assertThat(rows[0][0]).isEqualTo(Direction.RIGHT);
        assertThat(rows[0][1]).isEqualTo(Direction.LEFT);

        assertThat(rows[1][2]).isEqualTo(Direction.RIGHT);
        assertThat(rows[1][3]).isEqualTo(Direction.LEFT);

        assertThat(rows[2][1]).isEqualTo(Direction.RIGHT);
        assertThat(rows[2][2]).isEqualTo(Direction.LEFT);
    }

}