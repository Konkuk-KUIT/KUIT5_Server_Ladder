import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderCreatorTest {

    @Test
    @DisplayName("랜덤 사다리에서 일자 라인 생성 불가능 테스트")
    void randomLadderHasNoConsecutiveLines() {
        // given
        int rows = 10;
        int cols = 5;
        LadderGame game = LadderGameFactory.createRandomLadderGame(rows, cols);
        LadderCreator ladder = game.getLadderCreator();

        // when
        Row[] rowList = ladder.getRows();

        // then
        for (Row row : rowList) {
            for (int c = 0; c < row.size() - 2; c++) {
                Direction curr = row.getState(Position.of(c));
                Direction next = row.getState(Position.of(c + 1));
                // 현재 위치가 RIGHT이고 다음 위치가 RIGHT이면 연속된 라인 -> 예외
                assertFalse(curr == Direction.RIGHT && next == Direction.RIGHT);
            }
        }
    }
}
