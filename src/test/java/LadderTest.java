import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 5})
    @DisplayName("drawline에서 drawrow 입력 범위는 0부터 row-1까지 가능")
    void testdrawlineRowException(int givendrawrow) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);

        //when & then
        assertThatThrownBy(() ->  creator.drawLine(givendrawrow,1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DRAW_ROWCOL.getMessage());

    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 3,5})
    @DisplayName("drawline에서 drawcol 입력 범위는 0부터 numberOfPerson-2까지 가능")
    //오른쪽으로 사다리 그리기 때문에 맨 오른쪽 줄 제외한 numberOfPerson-2까지만 가능
    void testdrawlineColException(int givendrawcol) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);


        //when & then
        assertThatThrownBy(() ->  creator.drawLine(2,givendrawcol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DRAW_ROWCOL.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"-1,-1", "3,2", "3,3", "-1,5"})
    @DisplayName("drawline에서 drawcol, drawrow 입력범위 둘 다 적합하지 않을때")
    //오른쪽으로 사다리 그리기 때문에 맨 오른쪽 줄 제외한 numberOfPerson-2까지만 가능
    void testdrawlineRowColException(int givendrawrow, int givendrawcol) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);


        //when & then
        assertThatThrownBy(() ->  creator.drawLine(givendrawrow,givendrawcol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DRAW_ROWCOL.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"0,0","1,1", "0,1", "2,1" })
    @DisplayName("drawline에서 선택 지점에서 오른쪽으로 가는 사다리 라인이 잘 그려지는지")
    void testDrawline(int givendrawrow, int givendrawcol) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);


        //when
        creator.drawLine(givendrawrow,givendrawcol);
        Row[] DrawResultRows =creator.getRows();
        Direction[] resultRow = DrawResultRows[givendrawrow].getRow();

        //then
        assertThat(resultRow[givendrawcol]).isEqualTo(Direction.RIGHT);
        assertThat(resultRow[givendrawcol+1]).isEqualTo(Direction.LEFT);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,1","1,1,1,0", "1,1,1,2"})
    @DisplayName("drawline에서 가로로 연속된 사다리 라인을 추가할 수 없음")
    void testValidateDrawContinuousLine(int givendrawrow, int givendrawcol, int givenCheckRow, int givenCheckCol) {
        //given
        LadderSize ladderSize = new LadderSize(4,4);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);


        //when
        creator.drawLine(givendrawrow,givendrawcol);

        //then
        assertThatThrownBy(() ->  creator.drawLine(givenCheckRow, givenCheckCol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_CONTINUOUS_LINE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"0,0,0,0", "1,0,1,0", "1,1,1,1"})
    @DisplayName("drawline에서 이미 존재하는 라인을 추가할 수 없음")
    void testValidateDrawExistingLine(int givendrawrow, int givendrawcol, int givenCheckRow, int givenCheckCol) {
        //given
        LadderSize ladderSize = new LadderSize(4,4);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);


        //when
        creator.drawLine(givendrawrow, givendrawcol);

        //then
        assertThatThrownBy(() -> creator.drawLine(givenCheckRow, givenCheckCol))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ALREADY_EXIST_LINE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("사다리 라인 1개도 없을 때 Run 결과는 선택한 라인 그대로 나와야함")
    void testRunNoDrawLine(int givenRunCol) {
        //given
        LadderSize ladderSize = new LadderSize(3,5);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);
        LadderGame game = new LadderGame(creator);
        //when & then
        assertThat(game.run(givenRunCol)).isEqualTo(givenRunCol);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,3", "3,2"})
    @DisplayName("Run 실행결과 잘되는지 확인1")
    void testRunDrawLine(int givenRunCol, int resultRunCol) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);

        creator.drawLine(0,0);
        creator.drawLine(1,0);
        creator.drawLine(2,1);
        LadderGame game = new LadderGame(creator);

        //when & then
        assertThat(game.run(givenRunCol)).isEqualTo(resultRunCol);
    }

    @ParameterizedTest
    @CsvSource({"1,4", "2,1", "3,3", "4,5", "5,2"})
    @DisplayName("Run 실행결과 잘되는지 확인2")
    void testRunDrawLine2(int givenRunCol, int resultRunCol) {
        //given
        LadderSize ladderSize = new LadderSize(4,5);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);


        creator.drawLine(0,0);
        creator.drawLine(1,1);
        creator.drawLine(2,2);
        creator.drawLine(3,1);
        creator.drawLine(0,3);
        LadderGame game = new LadderGame(creator);

        //when & then
        assertThat(game.run(givenRunCol)).isEqualTo(resultRunCol);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4, 5})
    @DisplayName("Run에서 선택하는 번호는 1~사다리의 개수 사이의 수만 가능함")
    void testRunColExpection(int givenRunSelect) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);
        LadderGame game = new LadderGame(creator);

        //when & then
        assertThatThrownBy(() -> game.run(givenRunSelect))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_SELECT_RUN_COL.getMessage());

    }

    @ParameterizedTest
    @ValueSource (ints = {1,2,3})
    @DisplayName("사다리 진행상태 출력 잘되는지 확인 ")
    void testPrintLadder(int givenRunCol) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator creator = new ManualLadderCreator(ladderSize);
        LadderGame game = new LadderGame(creator);

        creator.drawLine(0,0);
        creator.drawLine(1,0);
        creator.drawLine(2,1);

        //when & then
        game.run(givenRunCol);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,3", "3,2"})
    @DisplayName("LadderGame으로 수동사다리 게임 진행")
    void testLadderGameManual(int givenRunCol, int resultRunCol) {
        //given
        LadderSize ladderSize = new LadderSize(3,3);
        ManualLadderCreator manualcreator = new ManualLadderCreator(ladderSize);
        LadderGame game = new LadderGame(manualcreator);


        manualcreator.drawLine(0,0);
        manualcreator.drawLine(1,0);
        manualcreator.drawLine(2,1);

        //when & then
        assertThat(game.run(givenRunCol)).isEqualTo(resultRunCol);
    }


    @DisplayName("LadderGame으로 자동사다리 게임 진행")
    @Test
    void testLadderGameRandom() {
        //given
        LadderSize ladderSize = new LadderSize(4,3);
        RandomLadderCreator randomCreator = new RandomLadderCreator(ladderSize);
        LadderGame game = new LadderGame(randomCreator);

        // then
        // 사다리 실행이 예외 없이 진행되는지 확인
        for (int startCol = 1; startCol <= ladderSize.getNumberOfPerson(); startCol++) {
            int result = game.run(startCol);
            // 결과가 1부터 사람수 사이인지
            assertThat(result).isBetween(1, ladderSize.getNumberOfPerson());
        }
    }


}