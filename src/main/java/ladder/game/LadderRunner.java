package ladder.game;

import ladder.LadderPosition;
import ladder.Position;
import ladder.Row;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            printLadder("Before", rowIndex, position);

            rows[rowIndex].nextPosition(position);

            printLadder("After", rowIndex, position);
        }

        printLadder("Result", rows.length - 1, position);

        return position.getValue();
    }

    private void printLadder(String label, int rowIndex, Position position) {
        System.out.println(label);
        LadderPosition ladderPosition = new LadderPosition(Position.from(rowIndex), position);
        LadderPrinter.printLadder(rows, ladderPosition);
    }
}