import java.util.List;

public class Ladder {

    private final Row[] rows;

    public Ladder(int row, int numberOfPerson){
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int drawrow, int drawcol) {
        validateDrawRow(drawrow);
        rows[drawrow].drawLine(drawcol);
    }

    private void validateDrawRow(int drawrow) {
        if ( rows.length<=drawrow || drawrow<0) {
            throw new IllegalArgumentException("요청한 사다리 라인의 위치가 적합하지 않습니다.");
        }
    }

    public int run(int selectcol) {
        validateRunCol(selectcol);

        for (Row row: rows) {
            selectcol = row.moveLadder(selectcol);
        }
        return selectcol;
    }

    private void validateRunCol(int selectcol) {
        if (selectcol<1 || selectcol > rows[0].getRow().length) {
            throw new IllegalArgumentException("1~" +rows[0].getRow().length +" 사이의 사다리 줄만 선택가능합니다.");
        }
    }

    public Row[] getRows() {
        return rows;
    }
}
