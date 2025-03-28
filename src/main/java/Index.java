public class Index {
    private final int value;

    private Index(int value) {
        this.value = value;
    }

    public static Index ofDrawCol(int value, int rowLength) {
        validateDrawCol(value, rowLength);
        return new Index(value);
    }

    public static Index ofDrawRow(int value, int totalRowCount) {
        validateDrawRow(value, totalRowCount);
        return new Index(value);
    }

    public static Index ofSelectCol(int value, int rowLength) {
        validateSelectCol(value, rowLength);
        return new Index(value - 1); // 내부는 0부터 사용
    }

    public void validateNoExistingLine(Direction[] row) {
        if (row[value] == Direction.RIGHT) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE.getMessage());
        }
    }

    public void validateNoContinuousLine(Direction[] row) {
        if (row[value] == Direction.LEFT ||
                (value < row.length - 1 && row[value + 1] == Direction.RIGHT)) {
            throw new IllegalArgumentException(ErrorMessage.NO_CONTINUOUS_LINE.getMessage());
        }
    }

    private static void validateDrawCol(int value, int rowLength) {
        if (value < 0 || value >= rowLength - 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_ROWCOL.getMessage());
        }
    }

    private static void validateDrawRow(int value, int totalRowCount) {
        if (value < 0 || value >= totalRowCount ) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DRAW_ROWCOL.getMessage());
        }
    }

    private static void validateSelectCol(int value, int rowLength) {
        if (value < 1 || value > rowLength ) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SELECT_RUN_COL.getMessage());
        }
    }

    public int getValue() {
        return value;
    }

    public Index right() {
        return new Index(value + 1);
    }

    public Index left() {
        if (value == 0) {
            throw new IllegalArgumentException(ErrorMessage.LEFT_MOVE_NOT_ALLOWED.getMessage());
        }
        return new Index(value - 1);
    }
}
