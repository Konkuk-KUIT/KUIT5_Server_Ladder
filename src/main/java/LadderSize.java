public class LadderSize {
    private final int row;
    private final int col;

    private LadderSize(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static LadderSize from(NaturalNumber row, NaturalNumber col) {
        return new LadderSize(row.getValue(), col.getValue());
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int calculateNumberOfLines() {
        return (int) (row * col * 0.3);
    }
}
