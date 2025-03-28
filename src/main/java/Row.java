public class Row {
    private  final Direction[] row;

    public Row(int numberOfPerson) {
        this.row = new Direction[numberOfPerson];
        for (int i = 0; i < numberOfPerson; i++) {
            row[i] = Direction.NONE;
        }
    }

    public void drawLine(Index drawcol) {
        int col = drawcol.getValue();
        //오른쪽으로 이동=1, 왼쪽으로 이동=-1
        row[col] = Direction.RIGHT; // 사다리 가로 라인 추가
        row[col+1] = Direction.LEFT; // 일단 지점 선택하면 그 지점에서 오른쪽으로 가로선 추가하도록 함
    }

    public Index moveLadder(Index selectcol) {
        int col = selectcol.getValue();
        if (row[col]==Direction.NONE) {
            return selectcol;
        }
        if (row[col]==Direction.RIGHT) {
            return selectcol.right();
        }

        return selectcol.left();

    }

    public Direction[] getRow() {
        return row;
    }
}
