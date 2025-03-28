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
        int position = start.getValue() - 1;

        for (int i = 0; i < rows.length; i++) {
            position += rows[i][position];
        }

        return position + 1;
    }
}

