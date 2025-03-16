public class Position {
    private int x;
    private int y;

    private Position(int x, int y) {
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException("invalid number");
        }
        this.x = x - 1;
        this.y = y - 1;
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

    public void checkLine(int[][] rows) {
        if (x > rows.length - 1) {
            throw new IllegalArgumentException("사다리의 높이보다 높은 위치입니다.");
        }

        if (y >= rows[0].length - 1) {
            throw new IllegalArgumentException("잘못된 사다리 번호입니다.");
        }

        if (rows[x][y] != 0) {
            throw new IllegalArgumentException("이미 사다리가 있습니다.");
        }

        if (rows[x][y + 1] != 0) {
            throw new IllegalArgumentException("이미 사다리가 있습니다.");
        }
    }
}