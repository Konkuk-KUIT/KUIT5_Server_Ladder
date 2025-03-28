import java.util.Random;

public class RandomLadderCreator implements LadderCreator {

    private final Row[] rows;
    private final Random random = new Random();

    private RandomLadderCreator(LadderCreator emptyLadder) {
        this.rows = emptyLadder.getRows();
        drawRandomLine();
    }

    public static RandomLadderCreator of(LadderCreator emptyLadder) {
        return new RandomLadderCreator(emptyLadder);
    }

    private void drawRandomLine() {
        //생성자에서 ladderSize를 받아서 사용하는게 나을까? 크기정보는 this.rows을 이용하면 다 알 수 있긴한데..
        int rowSize = rows.length;
        int colSize = rows[0].size();//ladderSize를 받지 않아서 size라는 메서드 추가로 만듬
        int numberOfLine = (int) (rowSize * colSize * 0.3);

        for (int i = 0; i < numberOfLine; i++) {
            try {
                Position randomRow = getRandomPosition(rowSize);
                Position randomCol = getRandomPosition(colSize - 1);
                drawLine(randomRow, randomCol);
            } catch (IllegalArgumentException e) {
                i--;
            }
        }
    }

    private Position getRandomPosition(int bound) {
        return Position.of(random.nextInt(bound));
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
