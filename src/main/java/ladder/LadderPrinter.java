package ladder;

public class LadderPrinter {
    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void printBefore(LadderPosition ladderPosition) {
        System.out.println("Before");
        printLadderWithCurrentPosition(ladderPosition);
    }

    public void printAfter(LadderPosition ladderPosition) {
        System.out.println("After");
        printLadderWithCurrentPosition(ladderPosition);
    }

    private void printLadderWithCurrentPosition(LadderPosition ladderPosition) {
        for (int i = 0; i < rows.length; i++) {
            checkLadderPosition(ladderPosition, i);
        }
    }

    private void checkLadderPosition(LadderPosition ladderPosition, int i) {
        if (i == ladderPosition.getX().getValue()){
            System.out.println(rows[i].printCurrentPosition(ladderPosition.getY()));
            return;
        }
        if (i != ladderPosition.getX().getValue()){
            System.out.println(rows[i]);
        }
    }

}
