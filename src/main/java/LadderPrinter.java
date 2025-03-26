public class LadderPrinter {
    private final Ladder ladder;

    private LadderPrinter(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderPrinter create(Ladder ladder) {
        return new LadderPrinter(ladder);
    }

    public void printLadder(int currentRow, Position position, String label) {
        System.out.println(label);
        StringBuilder sb = new StringBuilder();
        LadderRows ladderRows = ladder.getLadderRows();  // 내부에서 rows 꺼냄

        for (int row = 0; row < ladderRows.getHeight(); row++) {
            sb.append(makeRow(row, currentRow, position, ladderRows)).append("\n");
        }
        System.out.print(sb);
    }

    private String makeRow(int row, int currentRow, Position position, LadderRows ladderRows) {
        StringBuilder rowSB = new StringBuilder();
        for (int column = 0; column < ladderRows.getWidth(); column++) {
            rowSB.append(getCurrentCellState(row, column, currentRow, position, ladderRows));
        }
        return rowSB.toString();
    }

    private String getCurrentCellState(int row, int column, int currentRow, Position position, LadderRows ladderRows) {
        if (row == 0) {
            return decideFirstLineCell(column);
        }
        if (column == 0) {
            return "| ";
        }

        String marker = checkMarker(row, column, currentRow, position);
        return ladderRows.getRowsValue(row, column) + marker + " ";
    }

    private static String decideFirstLineCell(int column) {
        return column == 0 ? "+ " : "- ";
    }

    private static String checkMarker(int row, int column, int currentRow, Position position) {
        if(row == currentRow && column == position.getCurrentPosition()){
            return "*";
        }
        return "";
    }
}
