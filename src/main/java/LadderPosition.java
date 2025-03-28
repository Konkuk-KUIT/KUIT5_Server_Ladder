public class LadderPosition {
    private int x;
    private int y;

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

    public void moveDown(){
        x++;
    }

    public void moveHorizontally(Direction direction) {
        y += direction.getValue();
    }

    public boolean matches(int col) {
        return this.y == col;
    }
}
