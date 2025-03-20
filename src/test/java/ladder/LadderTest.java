package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("요청한 대로 사다리에 라인을 그어야 한다.")
    void testDrawLine(){
        // given
        Ladder ladder = new Ladder(3,3);
        int[][] arr = ladder.getLadder();
        int startX = 1;
        int startY = 1;
        int endX = 1;
        int endY = 2;
        int direction = -1;

        // when
        ladder.drawLine(new Position(startX, startY, direction));

        // then
        assertThat(arr[startX][startY]).isEqualTo(direction);
        assertThat(arr[endX][endY]).isEqualTo(-1*direction);
    }

    @Test
    @DisplayName("라인을 긋는 위치는 사다리 크기를 벗어날 수 없다.")
    void throwExceptionWhenPositionInvalid(){
        // given
        String expectedErrorMessage = "사다리의 범위를 벗어난 입력입니다.";
        Ladder ladder = new Ladder(3,3);

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(new Position(0,0,0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }

    @Test
    @DisplayName("한 위치에 두 개 이상의 라인을 그을 수 없다.")
    void throwExceptionWhenLineInvalid(){
        // given
        String expectedErrorMessage = "해당 위치에 이미 라인이 존재합니다.";
        Ladder ladder = new Ladder(3,3);
        ladder.drawLine(new Position(1,2,-1));

        // when & then
        assertThatThrownBy(() -> ladder.drawLine(new Position(1,1,-1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);

    }

    @Test
    @DisplayName("사다리 번호를 선택하면 정상적으로 결과값을 리턴해야 한다.")
    void testRun(){
        // given
        Ladder ladder = new Ladder(3,3);
        ladder.drawLine(new Position(1,1,-1));
        ladder.drawLine(new Position(2,2,-1));
        ladder.drawLine(new Position(3,2,1));

        // when
        int result1 = ladder.run(1);
        int result2 = ladder.run(2);
        int result3 = ladder.run(3);

        // then
        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(1);
    }
}