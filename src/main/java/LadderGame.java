// 사다리에 선을 그리는 클래스
public class LadderGame {
    private final LadderRows rows;
    private final LadderPrinter ladderPrinter;

    private LadderGame(LadderRows rows) {
        this.rows = rows;
        this.ladderPrinter = new LadderPrinter(rows);
    }
    public static LadderGame of(LadderRows rows) {
        return new LadderGame(rows);
    }
    public int run(NaturalNumber startPosition){
        Position position= Position.of(startPosition.getNaturalNumber());
        ValidationPosition.of(rows.getRows(),position.getCurrentPosition());
        for (int i = 1; i < rows.getHeight(); i++) {
            ladderPrinter.printLadder(i, position,"Before");
            position.calculatePosition(rows.getRowsValue(i, position.getCurrentPosition()));
            ladderPrinter.printLadder(i, position,"After");
        }
        return position.getCurrentPosition();
    }
}
