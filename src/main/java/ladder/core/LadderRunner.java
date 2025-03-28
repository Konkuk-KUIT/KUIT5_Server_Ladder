package ladder.core;

import ladder.position.LadderPosition;
import ladder.position.Position;

import static ladder.core.LadderLabel.AFTER;
import static ladder.core.LadderLabel.BEFORE;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public void run(Position position) {
        LadderViewer ladderViewer = new LadderViewer(rows);
        for (int i = 0; i < rows.length; i++) {
            ladderViewer.printLadderStatus(LadderPosition.of(Position.from(i), position), BEFORE);
            rows[i].nextPosition(position);
            ladderViewer.printLadderStatus(LadderPosition.of(Position.from(i), position), AFTER);
        }
    }

    public void printLadderStatus(LadderPosition ladderPosition, String label) {
        System.out.println(label);
        String generate = generate(ladderPosition);
        System.out.println(generate);
    }

    private String generate(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows.length; i++) {
            rows[i].generateRow(sb, Position.from(i), ladderPosition);
        }
        return sb.toString();
    }
}
