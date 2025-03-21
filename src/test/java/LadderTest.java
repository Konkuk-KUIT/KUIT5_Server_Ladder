import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    // 사다리 생성
    @ParameterizedTest
    @DisplayName("실패: 사다리를 생성할 때 row 와 numberOfPerson 로 0 과 음수를 넘기면 실패한다.")
    @CsvSource({"-2, -1",
            "-1, 1",
            "1, -1",
            "0, 3",
            "3, 0",
            "0, 0"
    })
    void testCreateLadderWithInvalidRowValues(int row, int numberOfPerson){
        //given
        assertThatThrownBy(() -> Ladder.createLadder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderException.INVALID_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("성공: 사다리를 만들때 row 와 numberOfPerson 모두 1 이상의 정수를 넘겨야한다.")
    @CsvSource({"2, 1",
            "1, 2",
            "10, 20",
            "1, 1"
    })
    void testCreateLadderWithValidRowValues(int row, int numberOfPerson){
        //given
        NaturalNumber rowNumber = NaturalNumber.of(row);
        NaturalNumber PersonNumber = NaturalNumber.of(numberOfPerson);

        //when
        Ladder ladder = Ladder.createLadder(rowNumber, PersonNumber);

        //then
        assertThat(ladder).isNotNull();
    }

    // drawLine test
    @ParameterizedTest
    @DisplayName("선택한 라인의 시작과 끝 숫자, 행이 0 이거나 음수일 수 없다.")
    @CsvSource({"-2, -1, -3",
            "-1, 1, 1",
            "1, -1, 1",
            "1, 1, -1",
            "0, 0, 0",
            "0, 1, 1",
            "1, 0, 0"
    })    void testRunWithInvalidValues(int start, int end, int row){
        //given
        String errorMessage = LadderException.INVALID_NUMBER.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(3), NaturalNumber.of(3));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(start), NaturalNumber.of(end), NaturalNumber.of(row)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("같은 번호로 line 을 그릴 수 없다.")
    @CsvSource({"1, 1",
            "2, 2"
    })
    void testDrawLineSameNumber(){
        //given
        String errorMessage = LadderException.SAME_NUMBER.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(3), NaturalNumber.of(3));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(1), NaturalNumber.of(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("1칸 이상을 이어서 라인을 그릴 수 없다.")
    @CsvSource({"4, 4, 1, 3, 2",
            "4, 4, 2, 4, 2"
    })
    void testDrawLineWhenLengthIsGreaterThanOne(int row, int numberOfPerson, int start, int end, int drawRow){
        //given
        String errorMessage = LadderException.INVALID_LINE_SPACING.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(start), NaturalNumber.of(end), NaturalNumber.of(drawRow)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @Test
    @DisplayName("라인이 인접해 있는 곳에 다시 그릴 수 없다.")
    void testCannotDrawLineOnAdjacentPosition(){
        //given
        String errorMessage = LadderException.LINE_POSITION_CONFLICT.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(4), NaturalNumber.of(4));
        ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(2), NaturalNumber.of(1));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(2), NaturalNumber.of(3), NaturalNumber.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @Test
    @DisplayName("라인이 이미 있는 곳에 다시 그릴 수 없다.")
    void testCannotDrawLineOnOccupiedPosition(){
        //given
        String errorMessage = LadderException.LINE_POSITION_CONFLICT.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(4), NaturalNumber.of(4));
        ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(2), NaturalNumber.of(1));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(2), NaturalNumber.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @Test
    @DisplayName("라인을 그리려는 행은 사다리의 행 길이 이내여야 한다.")
    void testLineRowMustBeWithinTotalLadderRows(){
        //given
        String errorMessage = LadderException.OUT_OF_ROW_LENGTH_RANGE.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(4), NaturalNumber.of(4));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(2), NaturalNumber.of(7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("라인을 그리려는 범위는 사다리의 열 길이 이내여야 한다.")
    @CsvSource({"5, 6",
            "4, 5",
            "5, 4",
    })
    void testLineMustBeWithinTotalLadderRows(int start, int end){
        //given
        String errorMessage = LadderException.OUT_OF_COLUMN_LENGTH_RANGE.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(4), NaturalNumber.of(4));

        //when & then
        assertThatThrownBy(() -> ladder.drawLine(NaturalNumber.of(start), NaturalNumber.of(end), NaturalNumber.of(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    // run test
    @ParameterizedTest
    @DisplayName("선택한 사다리의 번호가 0 이거나 음수일 수 없다.")
    @ValueSource(ints = {-1 , 0, -2})
    void testRunWithInvalidValues(int targetNumber){
        //given
        String errorMessage = LadderException.INVALID_NUMBER.getMessage();
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(2), NaturalNumber.of(3));

        //when & then
        assertThatThrownBy(() -> ladder.run(NaturalNumber.of(targetNumber)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @ParameterizedTest
    @DisplayName("사다리에 Line 이 없을 때 시작 번호 그대로 반환해야한다.")
    @ValueSource(ints = {1, 2, 3})
    void testRunWithoutDrawLine(int targetNumber){
        //given
        NaturalNumber targetNum = NaturalNumber.of(targetNumber);
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(2), NaturalNumber.of(3));

        //when
        int result = ladder.run(targetNum);

        //then
        assertThat(result).isEqualTo(targetNumber);
    }

    @Test
    @DisplayName("line 이 있을 때, run 메소드 동작 테스트")
    void testRunWithDrawLines(){
        //given
        Ladder ladder = Ladder.createLadder(NaturalNumber.of(3), NaturalNumber.of(4));

        //when
        ladder.drawLine(NaturalNumber.of(1), NaturalNumber.of(2), NaturalNumber.of(1));
        ladder.drawLine(NaturalNumber.of(2), NaturalNumber.of(3), NaturalNumber.of(2));
        ladder.drawLine(NaturalNumber.of(3), NaturalNumber.of(2), NaturalNumber.of(3));

        int result = ladder.run(NaturalNumber.of(1));

        //then
        assertThat(result).isEqualTo(2);
    }

}