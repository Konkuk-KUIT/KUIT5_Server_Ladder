public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int start, int end, int row) {
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
