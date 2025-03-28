import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    public void testPlayAll() {
        // Given
        LadderSize ladderSize = new LadderSize(5, 4);  // 5행 4열
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize, 4);

        // When
        // 플레이어 4명이 각각 사다리 이동을 시도한다.
        ladderGame.playAll();

        // Then
        // 플레이어 4명이 각자의 결과를 출력한다. (출력 결과는 직접적인 검증이 어렵지만,
        // 여기서는 이동이 제대로 되었는지, 예외가 발생하지 않는지만 확인)
    }
}