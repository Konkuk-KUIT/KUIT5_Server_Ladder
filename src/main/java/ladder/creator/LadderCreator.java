package ladder.creator;

import ladder.*;

public class LadderCreator {

    private final Row[] rows;

    public LadderCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getHeightValue()];
        for (int i = 0; i < ladderSize.getHeightValue(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRowPosition()].drawLine(ladderPosition.getCol());
    }

    public Row[] getRows() {
        return rows;
    }
}
