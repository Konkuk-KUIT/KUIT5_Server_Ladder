import java.util.List;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public int move(int startX) {
        LadderPosition position = new LadderPosition(startX, 0);

        for (Row row : rows) {
            position = row.move(position);
        }

        return position.getX();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            sb.append(row.toString()).append("\n");
        }
        return sb.toString();
    }
}