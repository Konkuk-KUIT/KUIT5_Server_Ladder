package ladder.core;

import ladder.utils.position.LadderPosition;
import ladder.utils.position.Position;

import static ladder.utils.Time.*;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        LadderPrinter ladderPrinter = new LadderPrinter(rows);

        for (int i = 0; i < rows.length; i++) {
            ladderPrinter.printLadder(LadderPosition.of(Position.from(i), position), BEFORE);
            rows[i].nextPosition(position);
            ladderPrinter.printLadder(LadderPosition.of(Position.from(i), position), AFTER);
        }
        return position.getValue();
    }
}