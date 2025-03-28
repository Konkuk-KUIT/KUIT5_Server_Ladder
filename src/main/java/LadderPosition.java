import java.util.Objects;

public class LadderPosition {
    private final int x;
    private final int y;

    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAt(int positionX) {
        return this.x == positionX;
    }

    public LadderPosition moveLeft() {
        return new LadderPosition(this.x - 1, this.y);
    }

    public LadderPosition moveRight() {
        return new LadderPosition(this.x + 1, this.y);
    }

    public LadderPosition moveDown() {
        return new LadderPosition(this.x, this.y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPosition that = (LadderPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}