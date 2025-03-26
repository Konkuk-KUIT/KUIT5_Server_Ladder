package ladder.core;

import ladder.utils.position.LadderPosition;
import ladder.utils.Time;

import static ladder.utils.Time.AFTER;

public class LadderPrinter {
    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void printLadder(LadderPosition ladderPosition, Time time) {
        StringBuilder sb = new StringBuilder();
        sb.append(time.getTime()).append("\n");

        for (int i = 0; i < rows.length; i++) {
            if (isSameHeight(ladderPosition, i)) {
                rows[i].printStar(sb, ladderPosition);
                continue;
            }
            rows[i].printRow(sb);
        }

        if (time == AFTER) {
            sb.append("---------------").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isSameHeight(LadderPosition ladderPosition, int i) {
        return ladderPosition.getRow().getValue() == i;
    }

}
