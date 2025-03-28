public class LadderRunner {
    private final Row[] rows;
    private final LadderPrinter ladderPrinter;

    private LadderRunner(LadderCreator ladder) {
        this.rows = ladder.getRows();
        this.ladderPrinter = LadderPrinter.from(this.rows);
    }

    public static LadderRunner of(LadderCreator ladder) {
        return new LadderRunner(ladder);
    }

    public int run(int start) {
        Position currentPosition = Position.of(start);

        for (int i = 0; i < rows.length; i++) {
            System.out.println("\nBefore");
            ladderPrinter.printLadder(currentPosition.getValue(), i);

            rows[i].move(currentPosition);

            System.out.println("\nAfter");
            ladderPrinter.printLadder(currentPosition.getValue(), i);
        }
        System.out.println(currentPosition.getValue());
        return currentPosition.getValue();
    }
}
