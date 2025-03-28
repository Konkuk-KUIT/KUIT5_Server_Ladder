package ladder;

import java.util.ArrayList;
import java.util.List;

// 사다리의 전체 세로줄을 관리하는 클래스
public class LadderLines {

    // 모든 세로줄 저장용 리스트
    private final List<Row> rows;

    //사람 수 만큼 세로줄 생성
    public LadderLines(LadderSize ladderSize) {
        this.rows = new ArrayList<>();
        for (int i = 0; i < ladderSize.getNumberOfPerson(); i++) {
            rows.add(new Row(ladderSize.getNumberOfRow()));
        }
    }

    // 특정 세로줄에 대해 줄을 그린다. -> Row에 위임
    public void drawLine(int x, int y) {
        validateColumnRange(x);
        rows.get(x).drawLine(y);
    }

    // 마지막 세로줄에 줄 못그리게 하기
    private void validateColumnRange(int x) {
        if (x < 0 || x >= rows.size() - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }

    public int getRowVal(int x, int y) {
        return rows.get(x).get(y);
    }

    // 사람 수
    public int getNumberOfPerson() {
        return rows.size();
    }

    // 사다리 높이
    public int getNumberOfRow() {
        return rows.get(0).length();
    }

    // 사다리 특정 위치 반환
    public String draw(int x, int y, LadderPosition cursor) {
        if (cursor.getX() == x && cursor.getY() == y) {
            return rows.get(x).get(y) + "*"; //현 위치
        }
        return String.valueOf(rows.get(x).get(y));
    }
}

