public class Line {
    // 사다리의 한 줄마다 이동하는 로직
    private final int[] moves;

    public Line(int[] moves) {
        this.moves = moves;
    }

    public void validateDrawLine(int col) {
        if (col < 0 || col >= moves.length - 1) {
            throw new IllegalArgumentException(ExceptionMsg.ALREADY_CONNECTED.getMessage());
        }
        if (moves[col] != 0 || moves[col + 1] != 0) {
            throw new IllegalStateException(ExceptionMsg.ALREADY_CONNECTED.getMessage());
        }
    }
}
