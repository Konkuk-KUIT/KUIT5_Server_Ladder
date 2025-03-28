package ladderGame;

public class Position {
    private Row row;
    private Column column;

    public Position(int row, int column, int height, int person) {
        this.row = new Row(row, height);
        this.column = new Column(column, person);
    }

    public Position(Position position) {
        this.row = new Row(position.getRow(), position.getHeight());
        this.column = new Column(position.getColumn(), position.getPerson());
    }

    public int getRow() {
        return row.getNumber();
    }

    public int getColumn() {
        return column.getNumber();
    }

    public int getHeight() {
        return row.getHeight();
    }

    public int getPerson() {
        return column.getPerson();
    }
}
