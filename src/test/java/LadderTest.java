import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class LadderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    @DisplayName("createEmptyLadder 검증")
    void testLadderInitialization() {
        int rowLength = 5;
        int numberOfPerson = 6;

        Ladder ladder = Ladder.createEmptyLadder(new NaturalNumber(rowLength), new NaturalNumber(numberOfPerson));

        assertThat(ladder.getPositions().getPositions().length).isEqualTo(rowLength);
        assertThat(ladder.getPositions().getPositions()[0].length).isEqualTo(numberOfPerson);
    }

    @Test
    @DisplayName("drawLine() 검증")
    void testLadderDrawLine(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));

        assertThat(ladder.getPositions().getPositions()[1][2].hasBridge()).isEqualTo(true);
    }

    @Test
    @DisplayName("drawLine() Throw 검증")
    void testLadderDrawLineThrows(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));

        assertThatThrownBy(() -> ladder.drawLine(new NaturalNumber(1), new NaturalNumber(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.LINE_UNREPEATABLE.getMessage());
    }

    @Test
    @DisplayName("drawLine() OutBound Throw 검증")
    void testLadderDrawLineThrowsOutBound(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);

        assertThatThrownBy(() -> ladder.drawLine(new NaturalNumber(100), new NaturalNumber(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITION_INVALID.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    @DisplayName("run() 검증")
    void testLadderRun(int givenNumberOfPerson){
        // 임의의 길이
        NaturalNumber rowLength = new NaturalNumber(givenNumberOfPerson);

        Ladder ladder = Ladder.createEmptyLadder(rowLength, new NaturalNumber(givenNumberOfPerson));

        assertThat(ladder.run(0))
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(givenNumberOfPerson - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    @DisplayName("run() throw 검증")
    void testLadderRunThrows(int givenIndexNumber){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);

        assertThatThrownBy(() -> ladder.run(givenIndexNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.START_INDEX_OUT_OF_BOUNDS.getMessage());
    }

    @Test
    @DisplayName("run() 출력 검증")
    void testLadderRunPrints(){
        System.setOut(new PrintStream(outContent));
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        Ladder ladder = Ladder.createEmptyLadder(rowLength, numberOfPerson);
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));
        ladder.drawLine(new NaturalNumber(1), new NaturalNumber(5));
        ladder.drawLine(new NaturalNumber(3), new NaturalNumber(4));
        ladder.drawLine(new NaturalNumber(4), new NaturalNumber(1));
        ladder.drawLine(new NaturalNumber(4), new NaturalNumber(3));
        ladder.run(2);

        assertThat(outContent.toString()).isEqualTo(
                """
                        Before
                        0 0 0* 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1 0 0\s
                        After
                        0 0 0 0 0 0\s
                        0 0 1* 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1 0 0\s
                        Before
                        0 0 0 0 0 0\s
                        0 0 1* 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1 0 0\s
                        After
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0* 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1 0 0\s
                        Before
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0* 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1 0 0\s
                        After
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0* 1 0\s
                        0 1 0 1 0 0\s
                        Before
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0* 1 0\s
                        0 1 0 1 0 0\s
                        After
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1* 0 0\s
                        Before
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1* 0 0\s
                        After
                        0 0 0 0 0 0\s
                        0 0 1 0 0 1\s
                        0 0 0 0 0 0\s
                        0 0 0 0 1 0\s
                        0 1 0 1 0 0\s
                        """
        );
        System.setOut(originalOut);
    }
}