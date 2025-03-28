import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {
    @ParameterizedTest
    @CsvSource({
            "2, 2",   // 입력값이 2일 때 결과는 2
            "1, 4",   // 입력값이 1일 때 결과는 3
            "3, 3",   // 입력값이 3일 때 결과는 1
            "4, 1"    // 입력값이 4일 때 결과는 4
    })
    @DisplayName("올바른 결과 테스트")
    void testLadder(int input, int expected) {
        // given
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(4, 4);

        ladderGame.drawLine(1,1);
        ladderGame.drawLine(2,2);
        ladderGame.drawLine(1,3);
        ladderGame.drawLine(3,1);
        ladderGame.drawLine(4,3);

        // when
        int result = ladderGame.run(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3",
            "2, 1"
    })
    @DisplayName("중복된 라인, 연결된 라인 오류 확인")
    void testLadder2(int row, int col) {
        // given
        LadderGame ladderGame = LadderGameFactory.createManualLadderGame(4, 4);
        ladderGame.drawLine(2, 2);

        // when & then
        assertThatThrownBy(()-> ladderGame.drawLine(row, col))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LINE_ALREADY_EXISTS.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 4",
            "2, -1",
            "3, 0",
            "4, 5"
    })
    @DisplayName("Column index out of range 확인")
    void testLadder3(int row, int col) {
        // given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(4, 4);

        // when & then
        assertThatThrownBy(()-> ladderGame.drawLine(row,col))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage(ErrorMessage.INVALID_COLUMN.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2",
            "-1, 1",
            "5, 3"
    })
    @DisplayName("Row index out of range 확인")
    void testLadder4(int row, int col) {
        // given
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(4, 4);

        // when & then
        assertThatThrownBy(()-> ladderGame.drawLine(row,col))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage(ErrorMessage.INVALID_ROW.getMessage());
    }

    @RepeatedTest(5)
    @DisplayName("자동 생성된 사다리가 유효하게 작동하는지 테스트")
    void testRandomLadderGame(){
        // given
        int row = 5;
        int person = 4;
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(row, person);

        // when & then
        for(int start=1;start<=person;start++){
            int result = ladderGame.run(start);

            // 사다리 결과는 1 이상 person 이하여야 함
            assertThat(result).isBetween(1, person);
        }
    }

    @RepeatedTest(3)
    @DisplayName("자동 생성된 사다리의 라인 개수 정책 만족 여부")
    void testLineountPolicy(){
        // given
        int row = 10;
        int person = 5;
        LadderSize ladderSize = new LadderSize(row, person);
        TestableLadder testableLadder = new TestableLadder(row, person);
        RandomLadderCreator ladderCreator = new RandomLadderCreator(ladderSize);

        // when
        ladderCreator.createLines(testableLadder);

        // then
        assertThat(testableLadder.getLineCount()).isLessThanOrEqualTo(ladderSize.getMaxLines());
    }

    @ParameterizedTest
    @DisplayName("Row가 0이면 예외 발생")
    @CsvSource({
            "0, 2",
            "-1, 3",
    })
    void rowIsTooSmall(int row, int col) {
        assertThatThrownBy(() -> new LadderSize(row, col))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MIN_ROW_TOO_SMALL.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Person이 1명 이하면 예외 발생")
    @CsvSource({
            "3, 1",
            "3, 0",
            "2, -1"
    })
    void personIsTooFew(int row, int col) {
        assertThatThrownBy(() -> new LadderSize(row, col))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 최소 2명 이상이어야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("정상적인 크기의 LadderSize는 예외 없이 생성됨")
    @CsvSource({
            "3, 4",
            "3, 5",
            "2, 3"
    })
    void validLadderSize(int row, int col) {
        LadderSize ladderSize = new LadderSize(row, col);

        assertThat(ladderSize.getNumberOfRow()).isEqualTo(row);
        assertThat(ladderSize.getNumberOfPerson()).isEqualTo(col);
    }
}