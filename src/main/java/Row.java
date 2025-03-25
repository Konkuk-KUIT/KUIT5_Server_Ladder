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

    public String toStringWithPosition(LadderPosition position) {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < directions.length; col++) {
            sb.append(directions[col].getValue());
            if (position != null && position.matches(col)) {
                sb.append("*");
            }
            sb.append("\t");
        }
        return sb.toString();
    }

    public int getLength() {
        return directions.length;
    }

}
