import exception.ExceptionMessage;

// 그릴 수 있는 위치인지 검증한다.
public class DrawPossible {
    private int rows[][];
    private int row;
    private int numberOfPerson;

    public DrawPossible(int rows[][],int row, int numberOfPerson) {
        this.rows = rows;
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }
    // 선을 그릴 위치를 검증하고 선을 다음 열과 잇도록 그린다.
    public void possibleAndDraw(int drawRow, int drawColumn) {
        // 존재하지 않는 배열 부분에 그리기 방지. 마지막 열에도 그릴 수 없음.
        if (drawRow > this.row || drawColumn >= this.numberOfPerson) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
        // 이미 선이 있는 경우 방지
        if (this.rows[drawRow][drawColumn] == 1 || this.rows[drawRow][drawColumn]==-1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATED_POSITION.getMessage());
        }
        // 연속된 선 그리기 방지
        if (this.rows[drawRow][drawColumn+1] == 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CONTINUOUS_LINE.getMessage());
        }
        // 위 조건을 모두 통과하면 해당위치는 1, 옮겨질 위치는 -1로 변경한다.
        rows[drawRow][drawColumn] = 1;
        rows[drawRow][drawColumn + 1] = -1;
    }
}
