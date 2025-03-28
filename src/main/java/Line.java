import util.Direction;
import util.ExceptionMsg;

public class Line {
    // 사다리의 한 줄마다 이동하는 로직
    private final Direction[] moves;

    public Line(Direction[] moves) {
        this.moves = moves;
    }

    public void validateDrawLine(int col) {
        if (col < 0 || col >= moves.length - 1) {
            throw new IllegalArgumentException(ExceptionMsg.ALREADY_CONNECTED.getMessage());
        }
        if (moves[col] != Direction.NONE || moves[col + 1] != Direction.NONE) {
            throw new IllegalStateException(ExceptionMsg.ALREADY_CONNECTED.getMessage());
        }
    }
}
