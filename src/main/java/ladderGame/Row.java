package ladderGame;

public class Row {
    private PositiveNumber number;
    private PositiveNumber height;

    public Row(int row, int height) {
        this.number = new PositiveNumber(row);
        this.height = new PositiveNumber(height);
        validate(row, height);
    }

    private void validate(int row, int height) {
        if (row > height)
            throw new IllegalArgumentException(ExceptionCode.ROW_OUT_OF_RANGE.getMessage());
    }

    public int getNumber() { return number.getNumber(); }

    public int getHeight() { return height.getNumber(); }
}