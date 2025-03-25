package ladder;

public class LadderPosition {
    private final Position x;
    private final Position y;

    private LadderPosition(Position x, Position y) {
        this.x = x;
        this.y = y;
    }

    public static LadderPosition of(Position x, Position y) {
        return new LadderPosition(x, y);
    }

    public boolean equalToPositionX(int number) {
        return this.x.getValue() == number;
    }

    public boolean equalToPositionY(int number) {
        return this.y.getValue() == number;
    }
}
