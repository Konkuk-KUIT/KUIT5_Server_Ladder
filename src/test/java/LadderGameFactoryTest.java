import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LadderGameFactoryTest {

    @Test
    public void testCreateRandomLadderGame() {
        // Given
        LadderSize ladderSize = new LadderSize(5, 4);  // 5행 4열

        // When
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize, 4);

        // Then
        assertNotNull(ladderGame);  // 게임 인스턴스가 생성되어야 함
    }
}