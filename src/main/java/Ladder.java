import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private final List<Row> rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new ArrayList<>();
        for (int i = 0; i < numberOfRow; i++) {
            rows.add(new Row(numberOfPerson));
        }
    }

    // 특정 위치(row, col)에 가로 선 추가
    public void drawLine(int row, int col){
        validate(row, col);
        rows.get(row).drawLine(col);
    }

    // 유효한 위치인지 검사
    public void validate(int row, int col){
        if (row < 0 || row >= rows.size()) {
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.INVALID_ROW.getMessage());
        }
        if (col < 0 || col >= rows.get(0).getLength() - 1) {
            throw new ArrayIndexOutOfBoundsException(ErrorMessage.INVALID_COLUMN.getMessage());
        }
        Direction d1 = rows.get(row).getDirection(col);
        Direction d2 = rows.get(row).getDirection(col + 1);
        if (d1 != Direction.NONE || d2 != Direction.NONE) {
            throw new IllegalArgumentException(ErrorMessage.LINE_ALREADY_EXISTS.getMessage());
        }
    }

    // 해당 위치의 방향 반환
    public Direction getDirection(int row, int col) {
        return rows.get(row).getDirection(col);
    }

    // 사다리 총 행(row)개수 반환
    public int getNumberOfRow() {
        return rows.size();
    }

    // 사다리 출력
    public void print(LadderPosition position) {
        for (int i = 0; i < rows.size(); i++) {
            if (i == position.getX()) {
                System.out.println(rows.get(i).toStringWithPosition(position));
            } else {
                System.out.println(rows.get(i).toStringWithPosition(null));
            }
        }
        System.out.println();
    }
}
