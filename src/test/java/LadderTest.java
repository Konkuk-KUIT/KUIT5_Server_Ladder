import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("drawline에서 drawrow 입력 범위는 0부터 row-1까지")
    void testdrawlineRowException(int givendrawrow) {
        //given
        String expectedMessage = "요청한 사다리 라인의 위치가 적합하지 않습니다.";
        Ladder ladder = new Ladder(3,3);

        //when & then
        assertThatThrownBy(() ->  ladder.drawLine(givendrawrow,1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3,5})
    @DisplayName("drawline에서 drawcol 입력 범위는 0부터 numberOfPerson-2까지")
    //오른쪽으로 사다리 그리기 때문에 numberOfPerson-2까지만 가능
    void testdrawlineColException(int givendrawcol) {
        //given
        String expectedMessage = "요청한 사다리 라인의 위치가 적합하지 않습니다.";
        Ladder ladder = new Ladder(3,3);

        //when & then
        assertThatThrownBy(() ->  ladder.drawLine(2,givendrawcol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource({"-1,-1", "3,2", "3,3", "-1,5"})
    @DisplayName("drawline에서 drawcol, drawrow 입력범위 둘 다 적합하지 않을때")
        //오른쪽으로 사다리 그리기 때문에 numberOfPerson-2까지만 가능
    void testdrawlineRowColException(int givendrawrow, int givendrawcol) {
        //given
        String expectedMessage = "요청한 사다리 라인의 위치가 적합하지 않습니다.";
        Ladder ladder = new Ladder(3,3);

        //when & then
        assertThatThrownBy(() ->  ladder.drawLine(givendrawrow,givendrawcol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource({"0,0","1,1", "0,1", "2,1" })
    @DisplayName("drawline에서 선택 지점에서 오른쪽으로 가는 사다리 라인이 잘 그려지는지")
    void testDrawline(int givendrawrow, int givendrawcol) {
        //given
        int RightMoveLadder = 1;
        int LeftMoveLadder = -1;
        Ladder ladder = new Ladder(3,3);

        //when
        ladder.drawLine(givendrawrow,givendrawcol);
        int[][] DrawResultRows = ladder.getRows();

        //then
        assertThat(DrawResultRows[givendrawrow][givendrawcol]).isEqualTo(RightMoveLadder);
        assertThat(DrawResultRows[givendrawrow][givendrawcol+1]).isEqualTo(LeftMoveLadder);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,1","1,1,1,0", "1,1,1,2"})
    @DisplayName("drawline에서 가로로 연속된 사다리 라인을 추가할 수 없음")
    void testValidateDrawContinuousLine(int givendrawrow, int givendrawcol, int givenCheckRow, int givenCheckCol) {
        //given
        String expectedMessage = "연속된 사다리 라인을 추가할 수 없습니다.";
        Ladder ladder = new Ladder(4,4);

        //when
        ladder.drawLine(givendrawrow,givendrawcol);

        //then
        assertThatThrownBy(() ->  ladder.drawLine(givenCheckRow, givenCheckCol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,0", "1,0,1,0", "1,1,1,1"})
    @DisplayName("drawline에서 이미 존재하는 라인을 추가할 수 없음")
    void testValidateDrawExistingLine(int givendrawrow, int givendrawcol, int givenCheckRow, int givenCheckCol) {
        //given
        String expectedMessage = "이미 존재하는 사다리 라인입니다.";
        Ladder ladder = new Ladder(4,4);

        //when
        ladder.drawLine(givendrawrow, givendrawcol);

        //then
        assertThatThrownBy(() -> ladder.drawLine(givenCheckRow, givenCheckCol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }
}