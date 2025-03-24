package ladder;

import ladder.creator.LadderCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class DrawLadderTest {
    @Test
    @DisplayName("Node가 없이 0으로만 그려진 사다리가 출력된다.")
    public void DrawRawLadderTest() {
        // given
        GreaterThanOne row = new GreaterThanOne(4);
        GreaterThanOne numberOfPerson = new GreaterThanOne(5);
        LadderCreator ladderCreator = new LadderCreator(row, numberOfPerson);

        // when
        StringBuilder sb = new StringBuilder();
        String expectedLadderStructure;
        for (int i = 0; i<row.getNumber(); i++)
        {
            for(int j=0; j<numberOfPerson.getNumber(); j++){
                sb.append("0");
            }
             sb.append("\n");
        }
        expectedLadderStructure = sb.toString();

        String ladderStructure = ladderCreator.presentLadder();


        // then
        assertThat(ladderStructure).isEqualTo(expectedLadderStructure);
    }
}
