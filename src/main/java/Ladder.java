public class Ladder {

    private final int[][] rows;

    private Ladder(final NaturalNumber row, final NaturalNumber numberOfPerson) {
        this.rows = new int[row.getValue()][numberOfPerson.getValue()];
    }

    public static Ladder from(NaturalNumber row, NaturalNumber numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    int[][] getRows() {
        return rows;
    }

    public int getRow() {
        return rows.length;
    }

    public int getCol() {
        return rows[0].length;
    }

    public int getLadderState(final int x, final int y) {
        return rows[x][y];
    }

    public boolean isValidStartPosition(NaturalNumber start) {
        int position = start.getValue() - 1;
        return position >= 0 && position < getCol();
    }
}
