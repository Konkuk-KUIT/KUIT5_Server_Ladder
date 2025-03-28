package ladder.creator;

import ladder.position.LadderPosition;
import ladder.core.LadderSize;
import ladder.core.Row;

public class CustomLadderCreator implements LadderCreator{

    private final Row[] rows;
    private final LadderSize ladderSize;

    public CustomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        rows = new Row[ladderSize.getHeightValue()];
        for (int i = 0; i < ladderSize.getHeightValue(); i++) {
            rows[i] = new Row(ladderSize.getNumberOfPerson());
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRowPosition()].drawLine(ladderPosition.getCol());
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    public LadderSize getLadderSize() {
        return ladderSize;
    }
}
