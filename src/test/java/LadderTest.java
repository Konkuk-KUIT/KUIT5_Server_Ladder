import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {

    @Test
    @DisplayName("createEmptyLadder 검증")
    void testLadderInitialization() {
        int rowLength = 5;
        int numberOfPerson = 6;

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);

        assertThat(ladder.getPositions().getPositions().length).isEqualTo(rowLength);
        assertThat(ladder.getPositions().getPositions()[0].length).isEqualTo(numberOfPerson);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("createEmptyLadder throw 검증")
    void testLadderInitializationThrows(int givenNumberOfPerson) {
        int rowLength = 5;

        assertThatThrownBy(() -> Ladder.createEmptyLadder(rowLength, givenNumberOfPerson))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NUMBER_OF_PERSON_OUT_OF_BOUNDS.getMessage());
    }

    @Test
    @DisplayName("drawLine() 검증")
    void testLadderDrawLine(){
        int rowLength = 5;
        int numberOfPerson = 6;

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);
        ladder.drawLine(1, 2);

        assertThat(ladder.getPositions().getPositions()[1][2].hasBridge()).isEqualTo(true);
    }

    @Test
    @DisplayName("drawLine() Throw 검증")
    void testLadderDrawLineThrows(){
        int rowLength = 5;
        int numberOfPerson = 6;

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);
        ladder.drawLine(1, 2);

        assertThatThrownBy(() -> ladder.drawLine(1, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.LINE_UNREPEATABLE.getMessage());
    }

    @Test
    @DisplayName("drawLine() OutBound Throw 검증")
    void testLadderDrawLineThrowsOutBound(){
        int rowLength = 5;
        int numberOfPerson = 6;

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);

        assertThatThrownBy(() -> ladder.drawLine(100, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITION_INVALID.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    @DisplayName("run() 검증")
    void testLadderRun(int givenNumberOfPerson){
        int rowLength = givenNumberOfPerson;

        Ladder ladder = Ladder.createEmptyLadder(rowLength, givenNumberOfPerson);

        assertThat(ladder.run(0))
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(givenNumberOfPerson - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    @DisplayName("run() throw 검증")
    void testLadderRunThrows(int givenIndexNumber){
        int rowLength = 5;
        int numberOfPerson = 6;

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);

        assertThatThrownBy(() -> ladder.run(givenIndexNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.START_INDEX_OUT_OF_BOUNDS.getMessage());
    }
}