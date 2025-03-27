// 사다리 관리 클래스
public class Ladder {

    private final Direction[][] rows;

    // 사다리 높이, 사다리 게임 참여하는 사람의 수
    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        this.rows = new Direction[row.getNum()][numberOfPerson.getNum()];
        for (int i = 0; i < row.getNum(); i++) {
            for (int j = 0; j < numberOfPerson.getNum(); j++) {
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
