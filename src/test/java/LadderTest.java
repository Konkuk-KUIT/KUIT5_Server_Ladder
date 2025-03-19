import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
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
        Ladder ladder = new Ladder(4,4);

        ladder.drawLine(1,1);
        ladder.drawLine(2,2);
        ladder.drawLine(1,3);
        ladder.drawLine(3,1);
        ladder.drawLine(4,3);

        // when
        int result = ladder.run(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3",
            "2, 1"
    })
    @DisplayName("중복된 라인, 연결된 라인 오류 확인")
    void testLadder2(int row, int col) {
        // given
        Ladder ladder = new Ladder(4,4);

        ladder.drawLine(2,2);

        // when & then
        assertThatThrownBy(()->ladder.drawLine(row,col))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("A line already exists");
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
        Ladder ladder = new Ladder(4,4);

        // when & then
        assertThatThrownBy(()->ladder.drawLine(row,col))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("Column index out of range");
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
        Ladder ladder = new Ladder(4,4);

        // when & then
        assertThatThrownBy(()->ladder.drawLine(row,col))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("Row index out of range");
    }
}