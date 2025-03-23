package ladder;

public class LadderPosition {
    private final int x;
    private final int y;

    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static LadderPosition of(int x, int y) {
        return new LadderPosition(x, y);
    }

    //같은 포지션인지
    public boolean isInARightPosition(int x, int y) {
        return this.x == x && this.y == y;
    }
}
