import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LadderCreatorTest {

    @Test
    public void testCreateLadder_SizeCorrect() {
        // given
        LadderCreator creator = new LadderCreator();
        int rowCount = 3;
        int numberOfPerson = 5;

        // when
        Ladder ladder = creator.createLadder(rowCount, numberOfPerson);

        // then
        assertNotNull(ladder); // 생성된 객체가 null이 아닌지 확인
        assertEquals(rowCount, ladder.getRows().length); // 행의 개수가 맞는지
        for (Row row : ladder.getRows()) {
            assertEquals(numberOfPerson, row.getLineStates().length); // 각 행의 열 개수가 맞는지
        }
    }

    @Test
    public void testCreateLadder_InitialStateIsNone() { // 초기값 NONE이 잘 세팅되어 있는지 확인
        // given
        LadderCreator creator = new LadderCreator();
        Ladder ladder = creator.createLadder(2, 4);

        // then
        for (Row row : ladder.getRows()) {
            for (LineValue value : row.getLineStates()) {
                assertEquals(LineValue.NONE, value);
            }
        }

    }
}