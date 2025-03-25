public class LadderPosition {
    private int x;
    private int y;

    public LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public LadderPosition(int y){
        this.x = 0;
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
    public boolean isSame(int row, int col) {
        return this.x == row && this.y == col;
    }

    public boolean matches(int col) {
        return this.y == col;
    }
}
