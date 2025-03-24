package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void run(Position position) {

        for (Row row : rows) {
            row.nextPosition(position);
            System.out.println("Before");
            printRow();
            System.out.println();
            row.nextStar(position);
            System.out.println("After");
            printRow();
            System.out.println();
        }
    }

    private void printRow(){
        for (Row row : rows) {
            row.showRow();
            System.out.println();
        }
    }
}
