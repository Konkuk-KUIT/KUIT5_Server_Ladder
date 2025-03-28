package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) { // position -> x좌표 의미
        for (int i = 0; i < rows.length; i++) {
            printLadderState(rows, new LadderPosition(position.getValue(), i));
            rows[i].nextPosition(position); // i -> y좌표 의미
            printLadderState(rows, new LadderPosition(position.getValue(), i));
        }
        return position.getValue();
    }

    private void printLadderState(Row[] rows, LadderPosition ladderPosition) {
        for (int i = 0; i < rows.length; i++) {
            printEachRow(rows, ladderPosition, i);
        }
    }

    private static void printEachRow(Row[] rows, LadderPosition ladderPosition, int i) {
        if (ladderPosition.getY() != i) {
            System.out.println(rows[i].rowToString());
        }
        if (ladderPosition.getY() == i) {
            System.out.println(rows[i].rowToStringWithStar(ladderPosition.getX()));
        }
    }
}
