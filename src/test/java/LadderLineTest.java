import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//사다리 높이가 양수일 때 정상적으로 row 초기화
//사다리 높이가 0 또는 음수일 때 예외 발생
//임시 테스트용

public class LadderLineTest {

    @Test
    void positive_height() {
        int height = 5;
        LadderLine ladderLine = new LadderLine(height);

        // height가 양수면 생성되는 모든 row 상태 0 초기화 필수
        for (int i = 0; i < height; i++) {
            assertEquals(0, ladderLine.getRowValue(i), "row 초기화");
        }
    }

    @Test
    //height가 0 or 음수
    void height_exception() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LadderLine(0);
        });
        assertEquals("사다리 높이는 1 이상이어야 합니다.", exception.getMessage());
    }

}
