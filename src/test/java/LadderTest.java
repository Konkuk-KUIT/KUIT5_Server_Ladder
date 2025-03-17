import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @ParameterizedTest
    @DisplayName("사다리에 Line 이 없을 때 시작 번호 그대로 반환해야한다.")
    @ValueSource(ints = {1, 2, 3})
    void testRunWithoutDrawLine(int targetNumber){
        //given
        Ladder ladder = new Ladder(2, 3);

        //when
        int result = ladder.run(targetNumber);

        //then
        assertThat(result).isEqualTo(targetNumber);
    }

    @Test
    @DisplayName("line 이 있을 때, run 메소드 동작 테스트")
    void testRunWithDrawLines(){
        //given
        Ladder ladder = new Ladder(3, 3);

        //when
        ladder.drawLine(1, 2, 1);
        ladder.drawLine(2, 3, 2);
        ladder.drawLine(3, 2, 3);

        int result = ladder.run(1);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 번호로 line 을 그릴 수 없다.")
    void testDrawLineSameNumber(){
        //given
        String errorMessage = LadderException.SAME_NUMBER.getMessage();
        Ladder ladder = new Ladder(3, 3);

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(1, 1, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}