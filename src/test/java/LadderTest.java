import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    //CsvSource 사용해서 통합
    // 입력값 null 도 예외처리
    @ParameterizedTest
    @DisplayName("사다리를 만들때 row 로 1 이상의 인자를 넘겨야한다.")
    @ValueSource(ints = {-2, -1, 0})
    void testCreateLadderWithInvalidRowValues(int row){
        //given
        assertThatThrownBy(() -> Ladder.createLadder(NaturalNumber.of(row), NaturalNumber.of(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderException.INVALID_LADDER_SIZE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("사다리를 만들때 numberOfPerson 으로 1 이상의 인자를 넘겨야한다.")
    @ValueSource(ints = {-2, -1, 0})
    void testCreateLadderWithInvalidNumberOfPersonValues(int numberOfPerson){
        //given
        assertThatThrownBy(() -> Ladder.createLadder(NaturalNumber.of(3), NaturalNumber.of(numberOfPerson)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderException.INVALID_LADDER_SIZE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("사다리에 Line 이 없을 때 시작 번호 그대로 반환해야한다.")
    @ValueSource(ints = {1, 2, 3})
    void testRunWithoutDrawLine(int targetNumber){
        //given
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(2), NaturalNumber.of(3));

        //when
        int result = ladder.run(targetNumber);

        //then
        assertThat(result).isEqualTo(targetNumber);
    }

    @Test
    @DisplayName("line 이 있을 때, run 메소드 동작 테스트")
    void testRunWithDrawLines(){
        //given
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(3), NaturalNumber.of(3));

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
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(3), NaturalNumber.of(3));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(1, 1, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

}