// 사다리 관리 클래스
public class Ladder {

    private final int[][] rows;

    // 사다리 높이, 사다리 게임 참여하는 사람의 수
    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int row, int col) {
        validateDrawLine(row, col);

        Line line = new Line(rows[row]);
        line.validateDrawLine(col);

        // 선 그리기
        rows[row][col] = 1;
        rows[row][col+1] = -1;
    }

    public int run (int startPosition){
        Position position = new Position(startPosition);

        for (int row = 0; row < rows.length; row++) {
            int direction = rows[row][position.getIndex()];
            position.move(direction);
        }

        return position.getIndex();
    }

    private void validateDrawLine(int row, int col){
        if (row < 0 || row >= rows.length || col < 0 || col >= rows[0].length - 1) {
            throw new IllegalArgumentException(ExceptionMsg.INVALID_LADDER_POSITION.getMessage());
        }

        if (rows[row][col] != 0 || rows[row][col + 1] != 0){
            throw new IllegalArgumentException(ExceptionMsg.ALREADY_CONNECTED.getMessage());
        }

    }

}
