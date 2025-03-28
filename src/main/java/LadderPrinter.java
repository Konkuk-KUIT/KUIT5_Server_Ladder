public class LadderPrinter {

    private final Row[] rows;

    private LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public static LadderPrinter from(Row[] rows) {
        return new LadderPrinter(rows);
    }

    public void printLadder(int currentCol, int currentRow) {
        for (int r = 0; r < rows.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < rows[r].size(); c++) {
                Direction direction = rows[r].getState(Position.of(c));
                // 방향 값(-1, 0, 1)을 문자열로 변환
                String value = String.valueOf(direction.getValue());

                // 현재 행, 열이면 마킹
                if (r == currentRow && c == currentCol) {
                    value += "*";
                }

                sb.append(String.format("%2s", value));
            }
            System.out.println(sb.toString());
        }
    }
}
