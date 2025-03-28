package ladder;

import ladder.position.LadderPosition;
import ladder.position.Position;

public class LadderRunner {

    private final Row[] rows;

    LadderPainter ladderPainter = new LadderPainter();

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }


    public int run(Position position) {



        for (int i = 0; i < rows.length; i++) {
            ladderPainter.printLadder("Before\n", new LadderPosition(Position.from(i), position), rows);
            rows[i].nextPosition(position);
            ladderPainter.printLadder("After\n", new LadderPosition(Position.from(i), position), rows);
        }
        return position.getValue();
    }







}
