package ladderGame;

public class LadderGame {
    LadderSize ladderSize;
    private boolean[][] positions;

    public LadderGame(int height, int person) {
        this.ladderSize = new LadderSize(height, person);
        positions = new boolean[height + 1][person];
    }

    public void drawLine(Position position) {
        validateAll(position);

        positions[position.getRow()][position.getColumn()] = true;
    }

    public int getHeight() {
        return ladderSize.getRow();
    }

    public int getWidth() {
        return ladderSize.getColumn();
    }

    public boolean hasLine(Position position) {
        return positions[position.getRow()][position.getColumn()];
    }

    private void validateAll(Position position) {
        validateRow(position);
        validateColumn(position);
        validatePresentLine(position);
        validateAdjLine(position);
    }

    private void validateRow(Position position) {
        if (position.getRow() > this.getHeight())
            throw new IllegalArgumentException(ExceptionCode.ROW_OUT_OF_RANGE.getMessage());
    }

    private void validateColumn(Position position) {
        if (position.getColumn() >= this.getWidth())
            throw new IllegalArgumentException(ExceptionCode.COLUMN_OUT_OF_RANGE.getMessage());
    }

    private void validatePresentLine(Position position) {
        if (positions[position.getRow()][position.getColumn()])
            throw new IllegalArgumentException(ExceptionCode.PRESENT_LINE.getMessage());
    }

    private void validateAdjLine(Position position) {
        if (isAdjLine(position)) { // 왼쪽에 인접한 선이 있는 경우
            throw new IllegalArgumentException(ExceptionCode.ADJACENT_LINE.getMessage());
        }
    }

    public boolean isAdjLine(Position position) {
        return ((position.getColumn() < getWidth() - 1 && positions[position.getRow()][position.getColumn() + 1]) // 오른쪽에 인접한 선이 있는 경우
                || (position.getColumn() > 1 && positions[position.getRow()][position.getColumn() - 1]));
    }
}