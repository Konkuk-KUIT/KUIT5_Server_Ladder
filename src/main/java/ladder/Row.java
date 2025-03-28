package ladder;

//세로줄 하나의 라인 관리용 클래스
public class Row {

    //0: 정지, 1: 오른쪽, -1: 왼쪽
    private final int[] line;

    // 사다리 높이만큼 배열 생성
    public Row(int numberOfRow) {
        validate(numberOfRow);
        this.line = new int[numberOfRow];
    }

    // 높이 유효성 검사 (1 이상)
    private void validate(int numberOfRow) {
        if (numberOfRow < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }
    }

    // 위치 반환
    public int get(int y) {
        return line[y];
    }

    // 줄 생성
    public void drawLine(int y) {
        validateDrawPosition(y);
        line[y] = Direction.RIGHT.getValue(); // 해당 줄에서는 오른쪽으로
        line[y + 1] = Direction.LEFT.getValue(); // 오른쪽 줄에서는 왼쪽으로
    }

    // 선 생성 가능한지 확인
    private void validateDrawPosition(int y) {
        // 인덱스 범위 검사 (0 <= y < line.length - 1)
        if (y < 0 || y >= line.length - 1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }

        // 이미 선이 그려진 위치인지 검사
        if (line[y] != Direction.NONE.getValue() || line[y + 1] != Direction.NONE.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DRAW_POSITION.getMessage());
        }
    }

    // 줄의 상태 반환
    public String draw(int x, int y) {
        if (x == y) {
            return line[x] + "*";  // 현재 위치 표시
        }
        return String.valueOf(line[x]);
    }

    // 줄 길이 반환
    public int length() {
        return line.length;
    }

}

