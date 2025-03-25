package ladder;

public class LadderRunner {

    private final Row[] rows;
    private final LadderPrinter ladderPrinter;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
        this.ladderPrinter = new LadderPrinter(rows);
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            LadderPosition ladderPosition = new LadderPosition(Position.from(i), position);
            ladderPrinter.printBefore(ladderPosition);

            rows[i].nextPosition(position);

            ladderPosition = new LadderPosition(Position.from(i), position);
            ladderPrinter.printAfter(ladderPosition);
        }
        return position.getValue();
    }
}
