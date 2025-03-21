public class Ladder {

    private final int[][] rows;

    private Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new int[row.getNumber()][numberOfPerson.getNumber()];
    }
    public static Ladder createLadder(NaturalNumber row, NaturalNumber numberOfPerson) {
        return new Ladder(row, numberOfPerson);
    }

    public void drawLine(NaturalNumber start, NaturalNumber end, NaturalNumber row) {

        Position position = Position.of(start, end);

        validRow(row);
        validPosition(row, position);

        rows[row.getNumber() - 1][position.getStart()] = Direction.RIGHT.getDirections();
        rows[row.getNumber() - 1][position.getEnd()] = Direction.LEFT.getDirections();

    }

    private void validPosition(NaturalNumber row, Position position) {
        if (rows[row.getNumber()][position.getStart()] != 0 || rows[row.getNumber()][position.getEnd()] != 0) {
            throw new IllegalArgumentException(LadderException.LINE_POSITION_CONFLICT.getMessage());
        }
        if (position.getStart() > rows[0].length || position.getEnd() > rows[0].length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_NUMBER_RANGE.getMessage());
        }
    }

    private void validRow(NaturalNumber row) {
        if (row.getNumber() > rows.length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_LENGTH_RANGE.getMessage());
        }
    }

    public int run(NaturalNumber targetNumber){
        if (targetNumber.getNumber() > rows[0].length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_NUMBER_RANGE.getMessage());
        }

        int targetColumn = targetNumber.getNumber() - 1;
        System.out.println(targetColumn);

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
