import exception.ExceptionMessage;

public class LadderRunner {

    private LadderRunner() {
    }

    public static LadderRunner from() {
        return new LadderRunner();
    }

    public int run(Ladder ladder, NaturalNumber start) {
        int[][] rows = ladder.getRows();
        int position = start.getValue() - 1;

        validateStartPosition(rows, position);

        for (int i = 0; i < rows.length; i++) {
            position += rows[i][position];
        }

        return position + 1;
    }

    private void validateStartPosition(int[][] rows, int position) {
        if (position < 0 || position >= rows[0].length) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }
    }
}

