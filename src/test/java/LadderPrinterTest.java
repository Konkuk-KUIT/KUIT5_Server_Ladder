import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderPrinterTest {
    @Test
    @DisplayName("사다리 출력이 잘 되는지 기본 생성만 하고 출력")
    void testPrintLadder(){
        // given
        Ladder ladder =new Ladder(NaturalNumber.of(4),NaturalNumber.of(5));
        ladder.tryToDrawLine(NaturalNumber.of(1),NaturalNumber.of(1));
        ladder.tryToDrawLine(NaturalNumber.of(2),NaturalNumber.of(2));
        ladder.tryToDrawLine(NaturalNumber.of(1),NaturalNumber.of(3));
        ladder.tryToDrawLine(NaturalNumber.of(3),NaturalNumber.of(1));
        ladder.tryToDrawLine(NaturalNumber.of(4),NaturalNumber.of(4));


        LadderGame ladderGame=LadderGame.of(ladder);

        // when
        LadderPrinter ladderPrinter = LadderPrinter.create(ladder);
        ladderGame.run(NaturalNumber.of(1));

        // then
        Assertions.assertThat(ladderPrinter).isNotNull();
    }
}