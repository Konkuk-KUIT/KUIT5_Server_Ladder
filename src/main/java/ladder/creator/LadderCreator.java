package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderPosition;
import ladder.Position;
import ladder.Row;

public class LadderCreator {

    private final Row[] rows;

    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRowPosition()].drawLine(ladderPosition.getCol());
    }

    public Row[] getRows() {
        return rows;
    }
}
