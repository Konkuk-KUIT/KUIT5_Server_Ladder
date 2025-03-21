public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    public int[][] getRows() {
        return rows;
    }

    public void drawLine(int drawrow, int drawcol) {
        validateDrawRowCol(drawrow, drawcol);
        validateDrawExistingLine(drawrow,drawcol);
        validateDrawContinuousLine(drawrow, drawcol);

        //오른쪽으로 이동=1, 왼쪽으로 이동=-1
        rows[drawrow][drawcol] = 1; // 사다리 가로 라인 추가
        rows[drawrow][drawcol+1] =-1; // 일단 지점 선택하면 그 지점에서 오른쪽으로 가로선 추가하도록 함
    }

    private void validateDrawRowCol(final int drawrow, final int drawcol) {
        if ( rows.length<=drawrow || drawrow<0 || rows[0].length-1<=drawcol || drawcol<0) {
            throw new IllegalArgumentException("요청한 사다리 라인의 위치가 적합하지 않습니다.");
        }
    }

    private void validateDrawContinuousLine(final int drawrow, final int drawcol) {
        if (rows[drawrow][drawcol]==-1 || drawcol< rows[0].length-1 && rows[drawrow][drawcol+1]==1) {
            throw new IllegalArgumentException("연속된 사다리 라인을 추가할 수 없습니다.");
        }
    }

    private void validateDrawExistingLine(final int drawrow, final int drawcol) {
        if (rows[drawrow][drawcol]==1) {
            throw new IllegalArgumentException("이미 존재하는 사다리 라인입니다.");
        }
    }

    public int run(int selectcol) {
        validateRunCol(selectcol);

        int row=0;
        while (row!=rows.length) {
            selectcol = moveLadder(row, selectcol);
            row+=1;
        }
        return selectcol;
    }

    private int moveLadder(int row, int selectcol) {
        if (rows[row][selectcol-1]==0) {
            return selectcol;
        }
        if (rows[row][selectcol-1]==1) {
            return selectcol+1;
        }
        return selectcol-1;

    }

    private void validateRunCol(int selectcol) {
        if (selectcol<1 || selectcol > rows[0].length) {
            throw new IllegalArgumentException("1~" +rows.length +" 사이의 사다리 줄만 선택가능합니다.");
        }
    }
}
