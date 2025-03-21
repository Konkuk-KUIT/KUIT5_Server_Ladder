public class Position {

    private final NaturalNumber start;
    private final NaturalNumber end;

    private Position(NaturalNumber start, NaturalNumber end) {
        this.start = start;
        this.end = end;
    }

    private static void validStartEndDifference(NaturalNumber start, NaturalNumber end) {
        if (start.getNumber() == end.getNumber()) {
            throw new IllegalArgumentException(LadderException.SAME_NUMBER.getMessage());
        }
        if (Math.abs(start.getNumber() - end.getNumber()) != 1) {
            throw new IllegalArgumentException(LadderException.INVALID_LINE_SPACING.getMessage());
        }
    }

    public static Position of(NaturalNumber start, NaturalNumber end) {
        validStartEndDifference(start, end);

        // end 보다 start 가 더 큰 경우, 값을 바꿔서 객체 생성 -> 항상 오른쪽에서 왼쪽으로 line drawing
        if (start.getNumber() > end.getNumber())
            return new Position(end, start);
        return new Position(start, end);
    }

    public void validPosition(int[][] rows, NaturalNumber row, Position position) {
        if (position.getStart() >= rows[0].length || position.getEnd() >= rows[0].length) {
            throw new IllegalArgumentException(LadderException.OUT_OF_COLUMN_LENGTH_RANGE.getMessage());
        }
        if (rows[row.getNumber() - 1][position.getStart()] != 0 || rows[row.getNumber() - 1][position.getEnd()] != 0) {
            throw new IllegalArgumentException(LadderException.LINE_POSITION_CONFLICT.getMessage());
        }
    }

    public int getStart() {
        return start.getNumber() - 1;
    }

    public int getEnd() {
        return end.getNumber() - 1;
    }
}
