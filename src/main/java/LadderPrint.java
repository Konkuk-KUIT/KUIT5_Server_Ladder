import util.Direction;

public class LadderPrint {
    public static void print(Direction[][] rows, int currentRow, int currentCol) {
        // 각 줄마다 반복
        for (int row = 0; row < rows.length; row++) {
            StringBuilder sb = new StringBuilder();
            drawLadder(rows, currentRow, currentCol, row, sb);
            System.out.println(sb.toString().trim());
        }
        System.out.println();
    }

    private static void drawLadder(Direction[][] rows, int currentRow, int currentCol, int row, StringBuilder sb) {
        for (int col = 0; col < rows[0].length; col++) {
            int value = rows[row][col].getDirection();
            if (row == currentRow && col == currentCol) {
                sb.append(value).append("*").append(" "); // 현재 위치면 * 출력
            } else {
                sb.append(value).append(" "); // 아니면 그냥 출력
            }
        }
    }


}
