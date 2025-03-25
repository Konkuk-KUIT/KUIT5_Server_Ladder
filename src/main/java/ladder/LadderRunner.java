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
            ladderPrinter.printBefore(LadderPosition.of(Position.from(i), position));
            rows[i].nextPosition(position);
            ladderPrinter.printAfter(LadderPosition.of(Position.from(i), position));
        }
        return position.getValue();
    }
}
