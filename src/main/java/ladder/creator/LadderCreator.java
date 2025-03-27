package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    public void drawLine(Position row, Position col);
    public Row[] getRows();
}
