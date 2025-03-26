package ladder.creator;

import ladder.utils.position.LadderPosition;
import ladder.core.LadderSize;
import ladder.core.Row;

public class LadderCreatorImpl implements LadderCreator {

    private final Row[] rows;

    public LadderCreatorImpl(LadderSize ladderSize) {
        rows = new Row[ladderSize.getRow().getNumber()];
        for (int i = 0; i < ladderSize.getRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getCol());
        }
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRow().getValue()].drawLine(ladderPosition.getCol());
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
