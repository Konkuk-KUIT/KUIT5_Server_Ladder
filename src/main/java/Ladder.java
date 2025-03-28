import common.exception.ExceptionMessage;

public class Ladder {

    private final int[][] rows;

    public Ladder(final NaturalNumber row, final NaturalNumber numberOfPerson) {
        this.rows = new int[row.getValue()][numberOfPerson.getValue()];
    }

    public void drawLine(Position position) {
        int x = position.getX();
        int y = position.getY();

        validatePosition(x, y);

        rows[x][y] = Direction.RIGHT.getValue();
        rows[x][y + 1] = Direction.LEFT.getValue();
    }

    public int run(NaturalNumber start) {
        int position = start.getValue() - 1;

        validateStartPosition(position);

        for (int i = 0; i < rows.length; i++) {
            position += rows[i][position];
        }

        return position + 1;
    }

    private void validatePosition(final int x, final int y) {
        if (x < 0 || x >= rows.length || y < 0 || y >= rows[0].length - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
        if (rows[x][y] != 0 || rows[x][y + 1] != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_HAS_LINE.getMessage());
        }
    }

    private void validateStartPosition(final int position) {
        if (position < 0 || position >= rows[0].length) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }
    }

    public int getRow() {
        return rows.length;
    }

    public int getCol() {
        return rows[0].length;
    }

    public int getLadderState(final int x, final int y) {
        return rows[x][y];
    }
}