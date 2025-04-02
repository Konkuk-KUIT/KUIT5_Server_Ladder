import exception.ExceptionMessage;

public class LadderRunner {

    private LadderRunner() {
    }

    public static LadderRunner from() {
        return new LadderRunner();
    }

    public int run(Ladder ladder, NaturalNumber start) {
        if (!ladder.isValidStartPosition(start)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }

        int[][] rows = ladder.getRows();
        LadderPosition position = LadderPosition.of(0, start.getValue() - 1);

        while (position.getX() < rows.length) {
            int direction = rows[position.getX()][position.getY()];
            LadderPosition moved = position.move(direction);
            position = moved.down();
        }

        return position.getY() + 1;
    }
}

