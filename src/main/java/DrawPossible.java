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

    public void possilbe(int drawRow, int drawColumn) {
        // 존재하지 않는 배열 부분에 그리기 방지
        if (drawRow >= this.row || drawColumn >= this.numberOfPerson) {
            throw new IllegalArgumentException("그릴 수 있는 범위를 초과했습니다.");
        }
        // 이미 선이 있는 경우 방지
        if (this.rows[drawRow][drawColumn] == 1 || this.rows[drawRow][drawColumn]==-1) {
            throw new IllegalArgumentException("이미 그려져있습니다.");
        }
        // 연속으로 선 그리기 방지 (3칸 연속 1이 되지 않도록  방지한다)
        if (drawColumn > 1 && this.rows[drawRow][drawColumn - 1] == 1 && this.rows[drawRow][drawColumn - 2] == 1) {
            throw new IllegalArgumentException("연속된 선을 그릴 수 없습니다.");
        }
        if (drawColumn < numberOfPerson - 2 && this.rows[drawRow][drawColumn + 1] == 1 && this.rows[drawRow][drawColumn + 2] == 1) {
            throw new IllegalArgumentException("연속된 선을 그릴 수 없습니다.");
        }
        // 위 조건을 모두 통과하면 해당 위치를 1로 바꿔준다.
        rows[drawRow][drawColumn] = 1;
    }
}
