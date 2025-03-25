public class LadderPrinter {
    private final LadderRows ladderRows;

    private LadderPrinter(LadderRows ladderRows) {
        this.ladderRows = ladderRows;
    }

    public static LadderPrinter create(LadderRows ladderRows) {
        return new LadderPrinter(ladderRows);
    }

    public void printLadder(int currentRow, Position position, String label) {
        System.out.println(label);
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < ladderRows.getHeight(); row++) {
            sb.append(makeRow(row, currentRow, position)).append("\n");
        }
        System.out.print(sb);
    }

    private String makeRow(int row, int currentRow, Position position) {
        StringBuilder rowSB = new StringBuilder();
        for (int column = 0; column < ladderRows.getWidth(); column++) {
            rowSB.append(getCurrentCellState(row, column, currentRow, position));
        }
        return rowSB.toString();
    }

    private String getCurrentCellState(int row, int column, int currentRow, Position position) {
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
