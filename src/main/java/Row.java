import java.util.Arrays;

public class Row {
    private final Direction[] directions;

    public Row(int numberOfPerson) {
        directions = new Direction[numberOfPerson];
        Arrays.fill(directions, Direction.NONE);
    }

    public void drawLine(int col) {
        directions[col] = Direction.RIGHT;
        directions[col + 1] = Direction.LEFT;
    }

    public Direction getDirection(int col) {
        return directions[col];
    }

    public int getLength() {
        return directions.length;
    }

}
