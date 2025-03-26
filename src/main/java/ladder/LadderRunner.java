package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            printLadder("Before\n", position, i);
            rows[i].nextPosition(position);
            printLadder("After\n", position, i);
        }
        return position.getValue();
    }

    private void printLadder(String prefix,Position position, int i) {
        System.out.println(prefix + ladderToString(new LadderPosition(Position.from(i), position)));
    }


    private String ladderToString(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<rows.length; i++) {
            sb.append(rows[i].nodeToString(i, ladderPosition));
            sb.append("\n");
        }
        return sb.toString();
    }


}
