import java.util.ArrayList;
import java.util.List;

/**
 LadderLines
 -LadderLine(사람당 1줄)들을 관리.
 */

public class LadderLines {
    private final List<LadderLine> lines;

    
     //사다리를 타고 도착하는 최종 column 반환
     // *현재 위치 값(0:이동X, 1:우, -1:좌)
    public int run(int startColumn) {
        // 시작값 범위 체크
        if (startColumn < 0 || startColumn >= lines.size()) {
            throw new IllegalArgumentException("없는 번호입니다.");
        }

        int currentColumn = startColumn;

        // row 0부터 마지막 row까지 이동.
        for (int row = 0; row < lines.get(0).getHeight(); row++) {
            int move = lines.get(currentColumn).getRowValue(row);

            // 이동 중 좌우 이동
            if (move == 1) {
                currentColumn++; // 오른쪽
            }
            if (move == -1) {
                currentColumn--; // 왼쪽
            }
            // move == 0 →좌우 X, 아래로만
        }

        // 도착지 반환
        return currentColumn;
    }



    public LadderLines(int PeopleNum, int height) {
        //사람 수와 높이 양수인지 확인
        if (PeopleNum <= 0 || height <= 0) {
            throw new IllegalArgumentException("사람 수와 사다리 높이는 1 이상이어야 합니다.");
        }

        lines = new ArrayList<>();
        for (int i = 0; i < PeopleNum; i++) {
            lines.add(new LadderLine(height));
        }
    }

    /**
     * 입력한 좌표에 가로줄(Line) 추가 기능
     * - column, row 범위 초과 금지(마지막 세로줄/높이 고려)
     * - 이미 줄이 있는 곳에는 불가
     * - 좌우 연속 줄 불가
     */
    public void drawLine(int column, int row) {
        // 1. column 범위 검사 (마지막 사람은 오른쪽 연결 불가)
        if (column < 0 || column > lines.size() - 2) {
            throw new IllegalArgumentException("줄을 그을 수 없는 사다리입니다.");
        }

        // 2. row 범위 검사 (0 이상, 높이 미만)
        if (row < 0 || row >= lines.get(0).getHeight()) {
            throw new IllegalArgumentException("줄을 그을 수 없는 높이입니다.");
        }

        // 3. 현재 위치나 오른쪽 위치에 이미 줄l 존재하는 경우
        if (lines.get(column).getRowValue(row) != 0 || lines.get(column + 1).getRowValue(row) != 0) {
            throw new IllegalArgumentException("이미 줄이 그어진 위치입니다.");
        }

        // 4. 왼쪽 줄 연속 방지
        if (column > 0 && lines.get(column - 1).getRowValue(row) == 1) {
            throw new IllegalArgumentException("왼쪽과 연속된 줄은 불가능합니다.");
        }

        // 5. 오른쪽 줄 연속 방지
        if (column + 2 < lines.size() && lines.get(column + 2).getRowValue(row) == -1) {
            throw new IllegalArgumentException("오른쪽과 연속된 줄은 불가능합니다.");
        }

        //문제 없으면 정상적으로 가로줄 추가
        lines.get(column).setRowValue(row, 1);    // 오른쪽
        lines.get(column + 1).setRowValue(row, -1); // 왼쪽
    }

    // 좌표 상테값 반환
    public int getRowValueAt(int column, int row) {
        return lines.get(column).getRowValue(row);
    }

}

