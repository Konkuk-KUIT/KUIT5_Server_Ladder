package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void testCreateLadder() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);

        //when
        Ladder ladder = new Ladder(numberOfRow, numberOfPerson);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사람 예외 처리 확인")
    void throwInvalidPersonException() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Ladder ladder = new Ladder(GreaterThanOne.from(2), numberOfPerson);

        //given
        int nthOfPerson = 4;

        //then
        assertThatThrownBy(() -> ladder.run(nthOfPerson))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 결과 확인")
    void testLadderResult() {
        //when
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);
        Ladder ladder = new Ladder(row, numberOfPerson);

        ladder.drawLine(0,0);
        ladder.drawLine(1,1);
        ladder.drawLine(2,0);

        //given
        int nthOfPerson = 0;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(2);

        //given
        nthOfPerson = 1;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(1);

        //given
        nthOfPerson = 2;

        //then
        assertThat(ladder.run(nthOfPerson)).isEqualTo(0);
    }
}
