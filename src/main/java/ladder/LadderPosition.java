package ladder;

public class LadderPosition {
    private int row;
    private int column;


    public LadderPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isSameAs(int row, int column) {
        if(this.row == row && this.column == column) {
            return true;
        }
        return false;
    }
}
