// 사다리 게임을 실행하는 클래스
public class LadderGame {
    private final Ladder ladder;

    private LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }
    public static LadderGame of(Ladder ladder) {
        return new LadderGame(ladder);
    }
    public int run(NaturalNumber startPosition){
        Position position= Position.of(startPosition.getNaturalNumber());
        LadderRows rows = ladder.getLadderRows();
        ValidationPosition.of(rows.getRows(),position.getCurrentPosition());
        LadderPrinter ladderPrinter = LadderPrinter.create(ladder);

        for (int i = 1; i < rows.getHeight(); i++) {
            ladderPrinter.printLadder(i, position,"Before");
            position.calculatePosition(rows.getRowsValue(i, position.getCurrentPosition()));
            ladderPrinter.printLadder(i, position,"After");
        }
        return position.getCurrentPosition();
    }
}
