public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int start, int end, int row) {

        if (start == end) {
            throw new IllegalArgumentException(LadderException.SAME_NUMBER.getMessage());
        }
        if (row > rows.length || row < 1 ) {
            throw new IllegalArgumentException(LadderException.OUT_OF_LENGTH_RANGE.getMessage());
        }
        if (start > rows[0].length || start < 1 || end > rows[0].length || end < 1) {
            throw new IllegalArgumentException(LadderException.OUT_OF_NUMBER_RANGE.getMessage());
        }

        if (start < end){
            rows[row - 1][start - 1] = 1;
            rows[row - 1][end - 1] = -1;
            return;
        }
        if (start > end){
            rows[row - 1][start - 1] = -1;
            rows[row - 1][end - 1] = 1;
        }
    }

    public int run(int targetNumber){
        if (targetNumber <= 0 || targetNumber > rows[0].length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_NUMBER_RANGE.getMessage());
        }

        int targetColumn = targetNumber - 1;

        for (int[] row : rows) {
            if (row[targetColumn] == 1) {
                targetColumn++;
                continue;
            }
            if (row[targetColumn] == -1) {
                targetColumn--;
            }
        }
        return targetColumn + 1;
    }

}
