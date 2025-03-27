public class Ladder {

    private final int[][] rows;

    public Ladder(GreaterThanZero row, GreaterThanZero numberOfPerson) {
        rows = new int[row.getNumber()][numberOfPerson.getNumber()];
    }

    /**
     * 유효한 좌표인지 확인 후,
     * 시작 점과 끝 점이 모두 0 이여야 사다리 줄이 그어진다.
     */
    public void drawLine(int startX, int startY, int endX, int endY) {
        validatePosition(startX, startY, endX, endY);
        if (checkIfItIsZero(startX, startY, endX, endY))
        {
            rows[startX][startY] = 1;
            rows[endX][endY] = -1;
        }
    }

    private void validatePosition(int startX, int startY, int endX, int endY) {
        int maxRow = rows.length;
        int maxCol = rows[0].length;

        Position.of(startX, startY, maxRow, maxCol);
        Position.of(endX, endY, maxRow, maxCol);

    }

    private boolean checkIfItIsZero(int startX, int startY, int endX, int endY) {
        return rows[startX][startY] == 0 && rows[endX][endY] == 0;
    }

    public int[][] getRows() {
        return rows;
    }

    public void printLadder() {
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                System.out.print(rows[i][j] + " ");
            }
            System.out.println();
        }
    }
}
