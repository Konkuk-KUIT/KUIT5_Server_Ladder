public class LadderRows {
    private final int[][] rows;

    public LadderRows(int rowSize, int numberOfPerson) {
        this.rows = new int[rowSize][numberOfPerson];
    }

    public void drawLine(int row, int column) {
        rows[row][column] = 1;
        rows[row][column + 1] = -1;
    }

    public int getRowsValue(int row, int column) {
        return rows[row][column];
    }

    public int getHeight() {
        return rows.length;
    }

    public int getWidth() {
        return rows[0].length;
    }

    public int[][] getRows() {
        return rows;
    }
}