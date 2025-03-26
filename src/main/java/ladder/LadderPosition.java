package ladder;

public class LadderPosition {
    private final Position row;
    private final Position column;


    public LadderPosition(Position row, Position column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column.getValue();
    }

    public int getRow() {
        return row.getValue();
    }

    public boolean isSameAs(int row, int column) {
        if(this.row.getValue() == row && this.column.getValue() == column) {
            return true;
        }
        return false;
    }
}
