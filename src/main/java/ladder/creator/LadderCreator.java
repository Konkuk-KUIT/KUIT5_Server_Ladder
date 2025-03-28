package ladder.creator;

import ladder.LadderPosition;
import ladder.Row;

public interface LadderCreator {

    void drawLine(LadderPosition ladderPosition);
    Row[] getRows();

}
