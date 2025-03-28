import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LadderSizeTest {

    @Test
    public void testCalculateNumberOfLines() {
        // Given
        LadderSize ladderSize = new LadderSize(5, 4);  // 5행 4열

        // When
        int lines = ladderSize.calculateNumberOfLines();

        // Then
        assertEquals(6, lines);  // 5 * 4 * 0.3 = 6
    }
}