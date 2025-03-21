public class Row {
    private final NaturalNumber row;

    private Row(NaturalNumber row) {
        this.row = row;
    }

    public static Row of(int rowLength, NaturalNumber row) {
        validRow(rowLength, row);
        return new Row(row);
    }

    public static void validRow(int rowLength, NaturalNumber row) {
        if (row.getNumber() > rowLength) {
            throw new IllegalArgumentException(LadderException.OUT_OF_ROW_LENGTH_RANGE.getMessage());
        }
    }

    public int getRow() {
        return row.getNumber() - 1;
    }
}
