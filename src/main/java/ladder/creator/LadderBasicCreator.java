package ladder.creator;

import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class LadderBasicCreator implements LadderCreator {

    private final Row[] rows;

    public LadderBasicCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getRowSize()];
        for (int i = 0; i < ladderSize.getRowSize(); i++) {
            rows[i] = new Row(ladderSize.getColumnSize());
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
