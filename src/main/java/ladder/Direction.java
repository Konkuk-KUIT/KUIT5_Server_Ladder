package ladder;

// 사다리 이동 방향
public enum Direction {
    LEFT(-1),    // 왼쪽
    RIGHT(1),    // 오른쪽
    NONE(0);     // 이동 없음

    private final int value;

    // 방향 값 설정
    Direction(int value) {
        this.value = value;
    }

    // 방향 값 반환
    public int getValue() {
        return value;
    }
}
