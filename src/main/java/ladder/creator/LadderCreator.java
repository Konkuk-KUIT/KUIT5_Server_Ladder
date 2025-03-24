package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

public class LadderCreator {

    private final Row[] rows;

    public LadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    public String presentLadder(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<rows.length; i++) {
            sb.append(rows[i].presentNode());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Row[] getRows() {
        return rows;
    }
}
