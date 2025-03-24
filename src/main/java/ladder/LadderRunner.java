package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {

        for (int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
            for (Row row : rows) {
            row.showRow();
            System.out.println();
            }
            System.out.println();
            rows[i].nextStar(position);
            for (Row row : rows) {
                row.showRow();
                System.out.println();
            }
            System.out.println();
        }
        return position.getValue();
    }
}
