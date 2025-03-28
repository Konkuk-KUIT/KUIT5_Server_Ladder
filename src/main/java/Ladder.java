import java.util.List;

public class Ladder {

    private final Row[] rows;

    public Ladder(int row, int numberOfPerson){
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public int run(int selectcol) {
        Index selcol = Index.ofSelectCol(selectcol, rows[0].getRow().length);

        for (Row row: rows) {
            selcol = row.moveLadder(selcol);
        }
        return selcol.getValue()+1;
    }

    public Row[] getRows() {
        return rows;
    }
}
