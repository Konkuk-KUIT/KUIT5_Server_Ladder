public class Ladder {
    private final int[][] rows;
    private final int numberOfPerson;
    private final int row;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
        this.numberOfPerson = numberOfPerson;
        this.row = row;
    }

    public void drawLine(int line, int level) {
        if (line < 1 || line > numberOfPerson - 1) {
            throw new IllegalArgumentException("선택된 라인과 그 오른편의 라인을 연결하므로 가장 끝 라인을 제외한 라인을 선택하세요.");
        }
        if (level < 1 || level > row) {
            throw new IllegalArgumentException("가능한 높이를 벗어났습니다.");
        }
        if (rows[level-1][line - 1] != 0 || rows[level-1][line] != 0) {
            throw new IllegalArgumentException("이미 선점된 위치입니다.");
        }
        rows[level-1][line - 1] = 1;
        rows[level-1][line] = -1;
    }

    public int run(int selectedLine) {
        if (selectedLine < 1 || selectedLine > numberOfPerson) {
            throw new IllegalArgumentException("선택할 수 없는 번호입니다.");
        }

        int currentLine = selectedLine - 1;

        for (int level = 0; level < row; level++) {
            currentLine += rows[level][currentLine];
        }

        return currentLine + 1;
    }
}