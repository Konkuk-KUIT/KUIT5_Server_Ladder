public class DefaultLadderCreator implements LadderCreator {

    private final Row[] rows;

    // 행과 열의 크기를 받아 사다리 배열을 초기화한다.
    private DefaultLadderCreator(LadderSize ladderSize) {
        this.rows = new Row[ladderSize.getNumberOfRow()];
        for (int i = 0; i < ladderSize.getNumberOfRow(); i++) {
            this.rows[i] = Row.of(ladderSize.getNumberOfPerson());
        }
    }
    public static DefaultLadderCreator of(LadderSize ladderSize) {
        return new DefaultLadderCreator(ladderSize);
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLineOnNode(Position.of(col.getValue()));
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    //test코드 용 state 반환 메서드
    @Override
    public Direction getState(Position row, Position col) {
        return rows[row.getValue()].getState(col);
    }

}