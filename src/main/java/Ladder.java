public class Ladder {
    private final Line line;

    public Ladder(int numberOfRow, int numberOfPerson) {
        this.line = new Line(numberOfRow, numberOfPerson);
    }

    public void drawLine(int row, int col){
        line.drawLine(row-1, col-1);
    }

    public int run(int selectedLadder){
        int row = 0;
        int col = selectedLadder-1;
        while(row < line.getNumberOfRow()){
            col = nextPosition(col, line.getDirection(row, col));
            row++;
        }
        return col+1;
    }

    public int nextPosition(int col, Direction direction){
        return col + direction.getValue();
    }
}
