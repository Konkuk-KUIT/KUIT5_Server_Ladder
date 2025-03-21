public class Row {
    private  final int[] row;

    public Row(int numberOfPerson) {
        this.row = new int[numberOfPerson];
    }

    public void drawLine(int drawcol) {
        validateDrawCol(drawcol);
        validateDrawExistingLine(drawcol);
        validateDrawContinuousLine(drawcol);

        //오른쪽으로 이동=1, 왼쪽으로 이동=-1
        row[drawcol] = 1; // 사다리 가로 라인 추가
        row[drawcol+1] =-1; // 일단 지점 선택하면 그 지점에서 오른쪽으로 가로선 추가하도록 함
    }

    private void validateDrawCol(final int drawcol) {
        if ( row.length-1<=drawcol || drawcol<0) {
            throw new IllegalArgumentException("요청한 사다리 라인의 위치가 적합하지 않습니다.");
        }
    }

    private void validateDrawContinuousLine(final int drawcol) {
        if (row[drawcol]==-1 || drawcol< row.length-1 && row[drawcol+1]==1) {
            throw new IllegalArgumentException("연속된 사다리 라인을 추가할 수 없습니다.");
        }
    }

    private void validateDrawExistingLine(final int drawcol) {
        if (row[drawcol]==1) {
            throw new IllegalArgumentException("이미 존재하는 사다리 라인입니다.");
        }
    }

    public int moveLadder(int selectcol) {
        if (row[selectcol-1]==0) {
            return selectcol;
        }
        if (row[selectcol-1]==1) {
            return selectcol+1;
        }

        return selectcol-1;

    }

    public int[] getRow() {
        return row;
    }
}
