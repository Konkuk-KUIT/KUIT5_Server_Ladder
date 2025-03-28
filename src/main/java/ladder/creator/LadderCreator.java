package ladder.creator;

import ladder.position.LadderPosition;
import ladder.core.Row;

public interface LadderCreator {

    void drawLine(LadderPosition ladderPosition);
    Row[] getRows();

}
