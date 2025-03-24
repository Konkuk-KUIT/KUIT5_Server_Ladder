import java.util.Arrays;

public class Ladder {
    private final Direction[][] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new Direction[numberOfRow][numberOfPerson];
        for (int i = 0; i < rows.length; i++) {
            Arrays.fill(rows[i], Direction.NONE);
        }
    }

    // 특정 위치(row, col)에 가로 선 추가
    public void drawLine(int row, int col){
        validateLine(row, col);
        rows[row][col] = Direction.RIGHT;
        rows[row][col+1] = Direction.LEFT;
    }

    // 유효한 위치인지 검사
    public void validateLine(int row, int col){
        if(col < 0 || col >= rows[0].length-1){
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.INVALID_COLUMN.getMessage());
        }
        if(row < 0 || row >= rows.length){
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.INVALID_ROW.getMessage());
        }
        if(rows[row][col] != Direction.NONE || rows[row][col+1] != Direction.NONE){
            throw new IllegalArgumentException(ErrorMessage.LINE_ALREADY_EXISTS.getMessage());
        }
    }

    // 해당 위치의 방향 반환
    public Direction getDirection(int row, int col){
        return rows[row][col];
    }

    // 사다리 총 행(row)개수 반환
    public int getNumberOfRow(){
        return rows.length;
    }
}
