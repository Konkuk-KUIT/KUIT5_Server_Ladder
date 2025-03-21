public class Line {
    // 사다리의 한 줄마다 이동하는 로직
    private final int[] moves;

    public Line(int width) {
        this.moves = new int[width];
    }

    public void draw(int col) {
        if (col >= moves.length - 1) {
            throw new IllegalArgumentException("마지막 열에는 선을 그을 수 없습니다.");
        }
        if (moves[col] != 0 || moves[col + 1] != 0) {
            throw new IllegalStateException("연속된 선이거나 이미 선이 그어져 있습니다.");
        }
        moves[col] = 1;
        moves[col + 1] = -1;
    }

    public void move(Position position) {
        int direction = moves[position.getIndex()];
        position.move(direction);
    }


}
