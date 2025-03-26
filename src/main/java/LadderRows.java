// 사다리 정보를 가지는 클래스
public class LadderRows {
    private final int[][] rows;

    public LadderRows(int rowSize, int numberOfPerson) {
        this.rows = new int[rowSize][numberOfPerson];
    }

    public void drawLine(int row, int column) {
        rows[row][column] = Direction.RIGHT.getValue();
        rows[row][column + 1] = Direction.LEFT.getValue();
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