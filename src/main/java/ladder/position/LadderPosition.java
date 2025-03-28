package ladder.position;

public class LadderPosition {
    private final Position row;
    private final Position column;

    public LadderPosition(Position row, Position column) {
        this.row = row;
        this.column = column;
    }

    public boolean isSameAs(int row, int column) {
        if(this.row.getValue() == row && this.column.getValue() == column) {
            return true;
        }
        return false;
    }
}
