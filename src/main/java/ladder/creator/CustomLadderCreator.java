package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class CustomLadderCreator implements LadderCreator{

    private final Row[] rows;

    public CustomLadderCreator(LadderSize<GreaterThanOne,GreaterThanOne> ladderSize) {
        rows = new Row[ladderSize.numberOfRow.getNumber()];
        for (int i = 0; i < ladderSize.numberOfRow.getNumber(); i++) {
            rows[i] = new Row(ladderSize.numberOfPerson);
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
