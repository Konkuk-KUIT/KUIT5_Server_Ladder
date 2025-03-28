package ladder;

public class LadderRunner {

    private final Row[] rows;
    private static final String BEFORE ="before";
    private static final String AFTER ="after";
    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void run(Position position) {

        for (Row row : rows) {
            row.nextPosition(position);
            System.out.println(BEFORE);
            printRow();
            row.nextStar(position);
            System.out.println(AFTER);
            printRow();
        }
    }

    private void printRow(){
        for (Row row : rows) {
            row.showRow();
            System.out.println();
        }
        System.out.println();
    }
}
