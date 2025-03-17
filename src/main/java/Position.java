public class Position {

    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void validateRow(int row){
        if(this.row > row-1) {
            throw new IllegalArgumentException("Invalid row position(row index couldn't be greater than ( Row - 1 ) )");
        }
        if(this.row<0){
            throw new IllegalArgumentException("Invalid row position(row index couldn't be negative)");
        }
    }

    public void validateColumn(int column){
        if(this.column > column-2) { // 지저분
            throw new IllegalArgumentException("Invalid column position(column index couldn't be greater than ( Column -2 ) )");
        }
        if(this.column < 0) {
            throw new IllegalArgumentException("Invalid column position(column index couldn't be negative)");
        }
    }

}
