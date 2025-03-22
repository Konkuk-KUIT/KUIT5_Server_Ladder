package ladderGame;

public class Ladder {
    private PositiveNumber person;
    private PositiveNumber ladderHeight;
    private boolean[][] positions;

    public Ladder(int person, int ladderHeight) {
        this.person = new PositiveNumber(person);
        this.ladderHeight = new PositiveNumber(ladderHeight);
        positions = new boolean[person + 1][ladderHeight + 1];
    }

    public void drawLine(Position position) {
        final int row = position.getRow(), column = position.getColumn();
        validateAll(row, column);

        positions[row][column] = true;
    }

    public int getHeight() {
        return ladderHeight.getNumber();
    }

    public int getWidth() {
        return person.getNumber();
    }

    public boolean hasLine(Position position) {
        final int row = position.getRow(), column = position.getColumn();
        return positions[row][column];
    }

    private void validateAll(int row, int column) {
        validateRow(row);
        validateColumn(column);
        validatePresentLine(row, column);
        validateAdjLine(row, column);
    }

    private void validateRow(int row) {
        if (row > ladderHeight.getNumber())
            throw new IllegalArgumentException(ExceptionCode.ROW_OUT_OF_RANGE.getMessage());
    }

    private void validateColumn(int column) {
        if (column > person.getNumber())
            throw new IllegalArgumentException(ExceptionCode.COLUMN_OUT_OF_RANGE.getMessage());
    }

    private void validatePresentLine(int row, int column) {
        if (positions[row][column])
            throw new IllegalArgumentException(ExceptionCode.PRESENT_LINE.getMessage());
    }

    private void validateAdjLine(int row, int column) {
        if ((column < person.getNumber() && positions[row][column + 1]) // 오른쪽에 인접한 선이 있는 경우
                || (column > 1 && positions[row][column - 1])) { // 왼쪽에 인접한 선이 있는 경우
            throw new IllegalArgumentException(ExceptionCode.ADJACENT_LINE.getMessage());
        }
    }
}