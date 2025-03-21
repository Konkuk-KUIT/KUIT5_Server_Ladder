public class Ladder {

    private final Row[] rows;

    public Ladder(int rowCount, int numberOfPerson) {
        if (!isValidLadder(rowCount, numberOfPerson)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_SIZE.getMessage());
        }
        rows = new Row[rowCount];
        for (int i = 0; i < rowCount; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public boolean isValidLadder(int row, int col){
        if (row < 1 || col < 2) {
            return false;
        }
        return true;
    }

    public void drawLine(int x, int y) {
        if (x < 0 || x >= rows.length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }

        rows[x].drawLine(y);
    }

    public Row[] getRows() {
        return rows;
    }
}