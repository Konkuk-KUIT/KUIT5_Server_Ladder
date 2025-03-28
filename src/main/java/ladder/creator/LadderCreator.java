package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderCreator {
    void drawLine(Position row, Position col);
    Row[] getRows();
}
