// 방향
public enum Direction {
    RIGHT(1),
    LEFT(-1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
