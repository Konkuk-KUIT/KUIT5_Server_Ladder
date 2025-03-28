package ladder.creator;

import ladder.Position;
import ladder.Row;

public interface LadderGenerator {
    void drawLine(Position row, Position col);
    Row[] getRows();
}