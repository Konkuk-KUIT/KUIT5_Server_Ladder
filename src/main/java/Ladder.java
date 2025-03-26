import java.util.Arrays;

public class Ladder {
    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) { // -> paramiterized
        rows = new Row[numberOfRow];
        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        validateDrawLineRow(row);
        rows[row].drawLine(col);
    }

    private void validateDrawLineRow(int row) {
        if (row < 0 || row > this.rows.length - 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_LINE_ROW.getMessage());
        }
    }

    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }
}