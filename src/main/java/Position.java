public class Position {
    private final int x;
    private final int y;

    private Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean invalidPosition(int[][] rows) {
        return x < 0 || x >= rows.length || y < 0 || y >= rows[0].length - 1;
    }

    public boolean hasLine(int[][] rows) {
        return rows[x][y] != 0 || rows[x][y + 1] != 0;
    }

    public boolean invalidStartPosition(int[][] rows, int position) {
        return position < 0 || position >= rows[0].length;
    }

}
