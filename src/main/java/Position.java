public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Position moveDown() {
        return new Position(this.row +1, this.col);
    }

    public Position moveLeft() {
        return new Position(this.row + 1, this.col - 1);
    }

    public Position moveRight() {
        return new Position(this.row + 1, this.col + 1);
    }
}
