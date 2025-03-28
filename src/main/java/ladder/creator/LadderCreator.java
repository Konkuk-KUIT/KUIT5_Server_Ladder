package ladder.creator;

import ladder.position.Position;
import ladder.Row;

public interface LadderCreator {



    public void drawLine(Position row, Position col);

    public Row[] getRows();


}
