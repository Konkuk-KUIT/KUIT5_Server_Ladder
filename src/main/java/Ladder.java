import util.Direction;
import util.ExceptionMsg;
import util.Position;

// 사다리 관리 클래스
public class Ladder {

    public Direction[][] getRows() {
        return rows;
    }

    private final Direction[][] rows;
    private final LadderSize ladderSize;

    // 사다리 높이, 사다리 게임 참여하는 사람의 수
    public Ladder(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
        this.rows = new Direction[ladderSize.getRowCount()][ladderSize.getPersonCount()];
        for (int i = 0; i < ladderSize.getRowCount(); i++) {
            for (int j = 0; j < ladderSize.getPersonCount(); j++) {
                rows[i][j] = Direction.NONE;
            }
        }
    }

    public void drawLine(int row, int col) {
        validateDrawLine(row, col);

        Line line = new Line(rows[row]);
        line.validateDrawLine(col);

        // 선 그리기
        rows[row][col] = Direction.RIGHT;
        rows[row][col+1] = Direction.LEFT;
    }

    public int run (int startPosition){
        Position position = new Position(startPosition);

        for(int row = 0; row < rows.length; row++) {
            System.out.println("Before");
            LadderPrint.print(rows, row, position.getIndex());

            Direction direction = rows[row][position.getIndex()];
            position.move(direction.getDirection());

            System.out.println("After");
            LadderPrint.print(rows, row, position.getIndex());}

        return position.getIndex();
    }

    private void validateDrawLine(int row, int col){
        if (row < 0 || row >= rows.length || col < 0 || col >= rows[0].length - 1) {
            throw new IllegalArgumentException(ExceptionMsg.INVALID_LADDER_POSITION.getMessage());
        }

        if (rows[row][col] != Direction.NONE || rows[row][col + 1] != Direction.NONE){
            throw new IllegalArgumentException(ExceptionMsg.ALREADY_CONNECTED.getMessage());
        }

    }

}
