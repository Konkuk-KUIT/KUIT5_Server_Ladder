import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomLadderCreatorTest {

    @Test
    public void testCreateLadder() {
        // Given
        LadderSize ladderSize = new LadderSize(5, 4);  // 5행 4열
        LadderCreator ladderCreator = new RandomLadderCreator();

        // When
        List<Row> rows = ladderCreator.createLadder(ladderSize);

        // Then
        assertNotNull(rows);
        assertEquals(5, rows.size());  // 5개의 행이 생성되어야 함

        // 각 행마다 사람이 있는지, 라인이 있는지 확인
        for (Row row : rows) {
            // 열 수는 4명이므로, 열 수는 3개여야 한다.
            // 각 행에 대해 points의 크기를 확인
            assertEquals(3, row.getPoints().size());

            // 각 row의 points에는 false 또는 true가 포함되어야 함
            for (Boolean point : row.getPoints()) {
                assertTrue(point == true || point == false);
            }
        }
    }
}