package ladder;

// 사다리에서의 위치에 대한 클래스
public class LadderPosition {

    // 현재 세로줄
    private final int x;

    // 현재 가로줄
    private final int y;

    // 위치를 입력 객체를 생성
    public LadderPosition(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_POSITION.getMessage());
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 아래로 이동
    public LadderPosition down() {
        return new LadderPosition(x, y + 1);
    }

    // 왼쪽으로 이동
    public LadderPosition left() {
        return new LadderPosition(x - 1, y);
    }

    // 오른쪽으로 이동
    public LadderPosition right() {
        return new LadderPosition(x + 1, y);
    }

    // 현재 위치를 좌표 문자열로 반환
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // 위치 비교를 위한 equals 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LadderPosition)) return false;
        LadderPosition other = (LadderPosition) obj;
        return this.x == other.x && this.y == other.y;
    }

    // hashSet 등에 사용되는 hashCode 오버라이드
    @Override
    public int hashCode() {
        return x * 31 + y;
    }
}

