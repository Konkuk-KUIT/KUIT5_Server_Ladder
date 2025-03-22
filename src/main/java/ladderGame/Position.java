package ladderGame;

public class Position {
    private PositiveNumber row, column;

    public Position(int row, int column) {
        this.row = new PositiveNumber(row);
        this.column = new PositiveNumber(column);
    }

    public int getRow() {
        return row.getNumber();
    }

    public int getColumn() {
        return column.getNumber();
    }
}
