import exception.ExceptionMessage;

public class LadderGame {
    private final int rows[][];
    private final int row;
    private final int numberOfPerson;

    private LadderGame(int rows[][],int row, int numberOfPerson) {
        this.rows = rows;
        this.row = row;
        this.numberOfPerson = numberOfPerson;
    }
    public static LadderGame of(int rows[][],int row, int numberOfPerson){
        possibleAndDraw(rows,row,numberOfPerson);
        return new LadderGame(rows,row,numberOfPerson);
    }
    // 선을 그릴 위치를 검증하고 선을 다음 열과 잇도록 그린다.
    private static void possibleAndDraw(int rows[][], int drawRow, int drawColumn) {
        IsValidPosition(rows,drawRow,drawColumn);
        IsDuplicatedLine(rows,drawRow,drawColumn);
        // 위 조건을 모두 통과하면 해당위치는 1, 옮겨질 위치는 -1로 변경한다.
        rows[drawRow][drawColumn] = 1;
        rows[drawRow][drawColumn + 1] = -1;
    }

    // 존재하지 않는 배열 부분에 그리기 방지. 마지막 열에도 그릴 수 없음.
    private static void IsValidPosition(int rows[][],int drawRow, int drawColumn) {
        if (drawRow >= rows.length || drawColumn >= rows[0].length-1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }
    // 이미 선이 있는 경우 방지
    private static void IsDuplicatedLine(int rows[][],int drawRow, int drawColumn) {
        if (rows[drawRow][drawColumn] == 1 || rows[drawRow][drawColumn]==-1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATED_POSITION.getMessage());
        }
    }
}
