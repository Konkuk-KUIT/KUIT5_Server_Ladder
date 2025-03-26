import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderPrinterTest {

    @ParameterizedTest
    @CsvSource({
            "2,2",
            "3,2",
            "7,5"
    })
    @DisplayName("LadderPrinter가 정상적으로 생성된다.")
    void testCreateLadderPrinter(int row, int numberOfPerson){
        // given
        Ladder ladder = new Ladder(NaturalNumber.of(row), NaturalNumber.of(numberOfPerson));

        // when
        LadderPrinter printer = LadderPrinter.create(ladder);

        // then
        assertThat(printer).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("printLadder가 현재 위치를 나타내는 것을 포함해서 예외 없이 잘 작동한다.")
    void testPrintLadderWithCurrentPosition(int currentRow){
        // given
        Ladder ladder = new Ladder(NaturalNumber.of(4), NaturalNumber.of(5));
        ladder.tryToDrawLine(NaturalNumber.of(2), NaturalNumber.of(2));
        Position position = Position.of(2);
        LadderPrinter printer = LadderPrinter.create(ladder);

        // when / then
        printer.printLadder(currentRow, position, "Test Ladder Output");
    }

    @ParameterizedTest
    @CsvSource({
            "1,2",
            "2,4",
            "3,3",
            "4,1",
            "5,5"
    })
    @DisplayName("사다리를 수동으로 생성하여 run을 했을 때 사다리 출력이 정상적으로 된다.")
    void testRunLadderWithPrint(int startPosition, int expectedResult){
        // given
        Ladder ladder = new Ladder(NaturalNumber.of(4), NaturalNumber.of(5));

        ladder.tryToDrawLine(NaturalNumber.of(1),NaturalNumber.of(3));
        ladder.tryToDrawLine(NaturalNumber.of(2),NaturalNumber.of(4));
        ladder.tryToDrawLine(NaturalNumber.of(2),NaturalNumber.of(2));
        ladder.tryToDrawLine(NaturalNumber.of(3),NaturalNumber.of(4));
        ladder.tryToDrawLine(NaturalNumber.of(4),NaturalNumber.of(1));
        ladder.tryToDrawLine(NaturalNumber.of(4),NaturalNumber.of(3));

        LadderGame ladderGame = LadderGame.of(ladder);

        // when
        int result = ladderGame.run(NaturalNumber.of(startPosition));

        // then
        assertEquals(expectedResult, result);
    }
}