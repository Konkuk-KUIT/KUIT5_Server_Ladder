public class Ladder {

    private Row[] rows;

    public Ladder(int rowSize, int numberOfPeople) {
        this.rows = new Row[rowSize];
        for (int i = 0; i < rowSize; i++) {
            this.rows[i] = new Row(numberOfPeople);
        }
    }

    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLineOnNode(col);
    }

    public int run(int start) {
        Position result = Position.of(start);
        for (int i = 0; i < rows.length; i++) {
            rows[i].move(result);
        }
        System.out.println(result.getValue());
        return result.getValue();
    }

    //test코드 용 state 반환 메서드
    public Direction getState(Position row, Position col) {
        return rows[row.getValue()].getState(col);
    }

}