package ladder;

public class LadderPosition {
    private final Position row;
    private final Position col;

    private LadderPosition(Position row, Position col) {
        this.row = row;
        this.col = col;
    }

    public static LadderPosition of(Position row, Position col) {
        return new LadderPosition(row, col);
    }

    public int getRow() {
        return row.getValue();
    }

    public int getCol() {
        return col.getValue();
    }

}
