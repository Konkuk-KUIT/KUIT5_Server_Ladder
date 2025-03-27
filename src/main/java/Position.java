public class Position {
    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Position of(int row, int col, int maxRow, int maxCol) {
        validatePosition(row, col, maxRow, maxCol);
        return new Position(row, col);
    }

    private static void validatePosition(int row, int col, int maxRow, int maxCol) {
        if (row < 0 || row >= maxRow
                || col < 0 || col >= maxCol) {
            throw new IllegalArgumentException("유효하지 않은 좌표 숫자입니다.");
        }
    }
}
