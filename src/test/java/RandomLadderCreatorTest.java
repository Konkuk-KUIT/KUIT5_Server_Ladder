import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RandomLadderCreatorTest {

    @Test
    @DisplayName("createLadder 검증")
    void testCreateLadder(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        assertThat(new RandomLadderCreator().createLadder(rowLength, numberOfPerson))
                .isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("resetLadder 검증")
    void testResetLadder(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);

        RandomLadderCreator generator = new RandomLadderCreator();
        generator.createLadder(rowLength, numberOfPerson);
        generator.resetLadder();

        assertThat(Arrays.stream(generator.getPositions().getPositions()) // Position[][] -> Stream<Position[]>
                .flatMap(Arrays::stream)) // Position[] -> Stream<Position>
                .extracting(Position::hasBridge)
                .containsOnly(false);
    }

    @Test
    @DisplayName("drawLine() 검증")
    void testDrawLine(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator();
        randomLadderCreator.createLadder(rowLength, numberOfPerson);
        randomLadderCreator.resetLadder();

        randomLadderCreator.drawLine(new NonNegativeNumber(3), new NonNegativeNumber(2));

        assertThat(randomLadderCreator.getPositions().getPosition(3, 2).hasBridge())
                .isEqualTo(true);
    }

    @Test
    @DisplayName("drawLine() Throws POSITION_INVALID")
    void testDrawLineThrowsPositionInvalidException(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator();
        randomLadderCreator.createLadder(rowLength, numberOfPerson);

        assertThatThrownBy(() -> randomLadderCreator.drawLine(new NonNegativeNumber(100), new NonNegativeNumber(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.POSITION_INVALID.getMessage());
    }

    @Test
    @DisplayName("drawLine() Throws LINE_UNREPEATABLE")
    void testDrawLineThrowsLineUnrepeatableException(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator();
        randomLadderCreator.createLadder(rowLength, numberOfPerson);
        randomLadderCreator.resetLadder();

        randomLadderCreator.drawLine(new NonNegativeNumber(3), new NonNegativeNumber(2));

        assertThatThrownBy(() -> randomLadderCreator.drawLine(new NonNegativeNumber(3), new NonNegativeNumber(1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.LINE_UNREPEATABLE.getMessage());

        assertThatThrownBy(() -> randomLadderCreator.drawLine(new NonNegativeNumber(3), new NonNegativeNumber(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.LINE_UNREPEATABLE.getMessage());
    }

    @Test
    @DisplayName("drawLine() Throws LINE_ALREADY_EXISTS")
    void testDrawLineThrowsLineAlreadyExistsException(){
        NaturalNumber rowLength = new NaturalNumber(5);
        NaturalNumber numberOfPerson = new NaturalNumber(6);
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator();
        randomLadderCreator.createLadder(rowLength, numberOfPerson);
        randomLadderCreator.resetLadder();

        randomLadderCreator.drawLine(new NonNegativeNumber(3), new NonNegativeNumber(2));

        assertThatThrownBy(() -> randomLadderCreator.drawLine(new NonNegativeNumber(3), new NonNegativeNumber(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.LINE_ALREADY_EXISTS.getMessage());
    }
}
