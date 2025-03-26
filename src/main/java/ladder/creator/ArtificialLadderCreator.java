package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class ArtificialLadderCreator implements LadderCreator {

    private final Row[] rows;

    public ArtificialLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }


    @Override
    public Row[] getRows() {
        return rows;
    }




    public int getRowLength() {
        return rows.length;
    }

    public int getColumnLength() {
        return rows[0].getNodelength();
    }
}
