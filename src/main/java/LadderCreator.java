import exception.ExceptionMessage;

public class LadderCreator {

    private LadderCreator() {
    }

    public static LadderCreator from() {
        return new LadderCreator();
    }

    public void drawLine(Ladder ladder, Position position) {
        int[][] rows = ladder.getRows();

        validatePosition(rows, position);

        rows[position.getX()][position.getY()] = Direction.RIGHT.getValue();
        rows[position.getY()][position.getY() + 1] = Direction.LEFT.getValue();
    }

    private void validatePosition(int[][] rows, Position position) {
        if (position.invalidPosition(rows)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
        if (position.hasLine(rows)) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_HAS_LINE.getMessage());
        }
    }
}
