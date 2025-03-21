import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("Number 클래스에 음수를 넣었을 때 에러반하는지 확인하는 테스트")
    void ifNumberIsNegative(){
        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자연수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("이상한 좌표에 사다리 생성 요청")
    void ifDrawNotAllowedPoint(){
        Number row = new Number(5);
        Number numberOfPerson = new Number(3);
        Position position = new Position(0,1);
        Ladder ladder = new Ladder(row,numberOfPerson);
        assertThatThrownBy(() -> ladder.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 시뮬레이션")
    void startGame(){
        // Given
        Number row = new Number(2);
        Number numberOfPerson = new Number(2);
        // 사다리 생성
        Ladder ladder = new Ladder(row,numberOfPerson);
        // 사다리 포인트 지정
        Position BridegeStart1 = new Position(1,1);
        Position BridgeEnd1 = new Position(1,2);
        Position BridegeStart2 = new Position(1,1);
        Position BridgeEnd2 = new Position(1,2);
        Number user = new Number(1);
        // 예상 결과
        int expected = 2;
        // When
        ladder.drawLine(BridegeStart1);
        ladder.drawLine(BridgeEnd1);
        ladder.drawLine(BridegeStart2);
        ladder.drawLine(BridgeEnd2);
        int result = ladder.run(user);
        // Then
        assertThat(result).isEqualTo(expected);
    }

}