// 사다리에 선을 그리는 클래스
public class LadderGame {
    private final LadderRows rows;

    private LadderGame(LadderRows rows) {
        this.rows = rows;
    }
    public static LadderGame of(LadderRows rows) {
        return new LadderGame(rows);
    }
    public int run(NaturalNumber startPosition){
        Position position= Position.of(startPosition.getNaturalNumber());
        ValidationPosition.of(rows.getRows(),position.getCurrentPosition());
        for (int i = 1; i < rows.getHeight(); i++) {
            position.calculatePosition(rows.getRowsValue(i, position.getCurrentPosition()));
        }
        return position.getCurrentPosition();
    }
}
