import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderGameFactoryTest {

    @Test
    @DisplayName("LadderGameFactory Factory Method 검증")
    public void testCreateRandomLadderGame() {
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        assertThat(LadderGameFactory.createRandomLadderGame(
                rowLength,
                numberOfPerson
        )).isInstanceOf(LadderGame.class);
    }
}
