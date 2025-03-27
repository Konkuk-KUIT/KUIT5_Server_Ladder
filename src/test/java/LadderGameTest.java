import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("LadderGame Factory Method 검증")
    public void testCreate() {
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        assertThat(LadderGame.create(
                new RandomLadderCreator(),
                rowLength,
                numberOfPerson
        )).isInstanceOf(LadderGame.class);
    }

    @Test
    @DisplayName("run() 검증")
    public void testRun() {
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);
        LadderGame ladderGame = LadderGame.create(
                new RandomLadderCreator(),
                rowLength,
                numberOfPerson
        );

        assertThat(ladderGame.run(3))
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(5);
    }
}
