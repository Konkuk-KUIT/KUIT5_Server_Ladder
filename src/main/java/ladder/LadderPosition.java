package ladder;

public class LadderPosition {
    private final Position x;
    private final Position y;

    public LadderPosition(Position x, Position y) {
        this.x = x;
        this.y = y;
    }

    public Position getX() {
        return x;
    }

    public Position getY() {
        return y;
    }
}
