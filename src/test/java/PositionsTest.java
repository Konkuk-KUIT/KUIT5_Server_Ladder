import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionsTest {

    @Test
    @DisplayName("Positions 생성자 검증")
    void testInitializePositions(){
        int row = 3;
        int col = 4;
        Positions positions = new Positions(row, col);


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                assertThat(positions.getPosition(i, j)).isNotNull();
            }
        }
    }
}
