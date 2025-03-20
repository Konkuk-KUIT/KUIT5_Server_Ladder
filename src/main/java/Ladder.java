public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        validLadderSize(row, numberOfPerson);
        rows = new int[row][numberOfPerson];
    }

    private static void validLadderSize(int row, int numberOfPerson) {
        if (row <= 0 || numberOfPerson <= 0) {
            throw new IllegalArgumentException(LadderException.INVALID_LADDER_SIZE.getMessage());
        }
    }

    public void drawLine(int start, int end, int row) {

        validStartEnd(start, end);
        validRow(row);

        if (start < end){
            rows[row - 1][start - 1] = Direction.RIGHT.getDirections();
            rows[row - 1][end - 1] = Direction.LEFT.getDirections();
            return;
        }
        if (start > end){
            rows[row - 1][start - 1] = Direction.LEFT.getDirections();
            rows[row - 1][end - 1] = Direction.RIGHT.getDirections();
        }
    }

    private void validStartEnd(int start, int end) {
        if (start == end) {
            throw new IllegalArgumentException(LadderException.SAME_NUMBER.getMessage());
        }
        if (start > rows[0].length || start < 1 || end > rows[0].length || end < 1) {
            throw new IllegalArgumentException(LadderException.OUT_OF_NUMBER_RANGE.getMessage());
        }
        if (Math.abs(start - end) != 1) {
            throw new IllegalArgumentException(LadderException.InvalidLinePositionException.getMessage());
        }
    }

    private void validRow(int row) {
        if (row > rows.length || row < 1 ) {
            throw new IllegalArgumentException(LadderException.OUT_OF_LENGTH_RANGE.getMessage());
        }
    }

    public int run(int targetNumber){
        if (targetNumber <= 0 || targetNumber > rows[0].length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_NUMBER_RANGE.getMessage());
        }

        int targetColumn = targetNumber - 1;

        for (int[] row : rows)
            targetColumn = getTargetColumn(row, targetColumn);

        return targetColumn + 1;
    }

    private static int getTargetColumn(int[] row, int targetColumn) {
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
