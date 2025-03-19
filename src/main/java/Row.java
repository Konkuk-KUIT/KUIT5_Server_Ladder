import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {
    private enum Direction {
        MOVE_RIGHT(1),
        MOVE_LEFT(-1);

        private final int value;

        Direction(int value){
            this.value = value;
        }
    }
    private final List<Integer> row;

    private Row(List<Integer> row) {
        this.row = row;
    }

    public static Row create(int size) {
        return new Row(new ArrayList<>(Collections.nCopies(size, 0)));
    }

    public void drawLine(int index) {
        validate(index);
        row.set(index - 1, Direction.MOVE_RIGHT.value);
        row.set(index, Direction.MOVE_LEFT.value);
    }

    private void validate(int index) {
        if (index < 1 || index > row.size() - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_LINE.getMessage());
        }
        if (row.get(index - 1) != 0 || row.get(index) != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_EXIST_POSITION.getMessage());
        }
    }

    public int move(int index) {
        return index + row.get(index);
    }
}
