public class LadderPosition {
    private final int x;
    private final int y;

    private LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static LadderPosition of(int x, int y) {
        return new LadderPosition(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public LadderPosition down() {
        return LadderPosition.of(x + 1, y);
    }

    public LadderPosition move(int direction) {
        return LadderPosition.of(x, y + direction);
    }
}
