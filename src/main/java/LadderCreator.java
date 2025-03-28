import exception.ExceptionMessage;

public class LadderCreator {

    private LadderCreator() {
    }

    public static LadderCreator from() {
        return new LadderCreator();
    }

    public void drawLine(Ladder ladder, Position position) {
        int[][] rows = ladder.getRows();
        int x = position.getX();
        int y = position.getY();

        validatePosition(rows, x, y);

        rows[x][y] = Direction.RIGHT.getValue();
        rows[x][y + 1] = Direction.LEFT.getValue();
    }

    private void validatePosition(int[][] rows, int x, int y) {
        if (x < 0 || x >= rows.length || y < 0 || y >= rows[0].length - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
        if (rows[x][y] != 0 || rows[x][y + 1] != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_HAS_LINE.getMessage());
        }
    }
}
