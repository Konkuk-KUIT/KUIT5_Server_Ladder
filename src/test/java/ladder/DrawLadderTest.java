package ladder;

import ladder.creator.ArtificialLadderCreator;
import ladder.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class DrawLadderTest {


    @Test
    @DisplayName("LadderStructure가 정상적인 사다리를 생성했는지 출력한다.")
    public void drawLadderStructure() {
        // given
        GreaterThanOne row = new GreaterThanOne(4);
        GreaterThanOne numberOfPerson = new GreaterThanOne(5);
        ArtificialLadderCreator ladderCreator = new ArtificialLadderCreator(row, numberOfPerson);

        Position position1 = Position.from(1);
        Position position2 = Position.from(2);
        ladderCreator.drawLine(position1, position1);
        ladderCreator.drawLine(position2, position2);

        //when & then
        LadderPainter ladderPainter = new LadderPainter();
        ladderPainter.printLadderStructure(ladderCreator.getRows());

    }

    @Test
    @DisplayName("게임을 실행하면 진행 과정이 별로 표시되어 출력된다.")
    void DrawStarAtLadder() {
        // given
        GreaterThanOne row = new GreaterThanOne(4);
        GreaterThanOne numberOfPerson = new GreaterThanOne(5);
        ArtificialLadderCreator ladderCreator = new ArtificialLadderCreator(row, numberOfPerson);

        Position position1 = Position.from(1);
        Position position2 = Position.from(2);
        ladderCreator.drawLine(position1, position1);
        ladderCreator.drawLine(position2, position2);


        // when & then
        LadderRunner ladderRunner = new LadderRunner(ladderCreator.getRows());
        int result = ladderRunner.run(Position.from(1));
        assertThat(result).isEqualTo(3);
    }


}
