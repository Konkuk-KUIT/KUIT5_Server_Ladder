public class Ladder {

    private final int[][] rows;

    private Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new int[row.getNumber()][numberOfPerson.getNumber()];
    }

    public static Ladder createLadder(NaturalNumber row, NaturalNumber numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    public void drawLine(NaturalNumber start, NaturalNumber end, NaturalNumber row) {
        Row drawRow = Row.of(rows.length, row);

        Position position = Position.of(start, end);
        position.validPosition(rows, row, position);

        rows[drawRow.getRow()][position.getStart()] = Direction.RIGHT.getDirections();
        rows[drawRow.getRow()][position.getEnd()] = Direction.LEFT.getDirections();
    }

    public int run(NaturalNumber targetNumber){
        if (targetNumber.getNumber() > rows[0].length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_COLUMN_LENGTH_RANGE.getMessage());
        }

        int targetColumn = targetNumber.getNumber() - 1;

        for (int[] row : rows)
            targetColumn = getTargetColumn(row, targetColumn);

        return targetColumn + 1;
    }

    private int getTargetColumn(int[] row, int targetColumn) {
        if (row[targetColumn] == Direction.RIGHT.getDirections()) {
            targetColumn++;
            return targetColumn;
        }
        if (row[targetColumn] == Direction.LEFT.getDirections()) {
            targetColumn--;
        }
        return targetColumn;
    }

}
