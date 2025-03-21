import java.util.zip.CheckedInputStream;

// 사다리 관리 클래스
public class Ladder {

    private final int[][] rows;

    // 사다리 높이, 사다리 게임 참여하는 사람의 수
    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public void drawLine(int row, int col) {
        if (row < 0 || row >= rows.length || col < 0 || col >= rows[0].length - 1) {
            throw new IllegalArgumentException("잘못된 사다리 위치입니다.");
        }

        if (rows[row][col] != 0 || rows[row][col + 1] != 0){
            throw new IllegalArgumentException("이미 선이 그어져 있거나 연속된 선입니다.");
        }

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

}
