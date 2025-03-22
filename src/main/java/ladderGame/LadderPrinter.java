package ladderGame;

public class LadderPrinter {
    private static final char rowLine = '│';
    private static final char columnLine = '─';
    private static final char moveLine = '↓';
    private static final char space = ' ';

    public static void printLadder(Ladder ladder, Position currentPosition) {
        for(int row = ladder.getHeight(); row >= 1; row--) {
            printColumn(ladder, currentPosition, row);
            System.out.println();
        }
        System.out.println();

    }

    private static void printColumn(Ladder ladder, Position currentPosition, int currentRow) {
        for (int column = 1; column <= ladder.getWidth(); column++) {
            printRowCell(currentPosition, currentRow, column);
            if (column < ladder.getWidth())
                printColumnCell(ladder, currentRow, column);
        }
    }

    private static void printRowCell(Position currentPosition, int currentRow, int currentColumn) {
        if (currentPosition.getRow() == currentRow && currentPosition.getColumn() == currentColumn) {
            System.out.print(moveLine);
            return;
        }

        System.out.print(rowLine);
    }

    private static void printColumnCell(Ladder ladder, int currentRow, int currentColumn) {
        if (ladder.hasLine(new Position(currentRow, currentColumn))) {
            System.out.print(columnLine);
            return;
        }

        System.out.print(space);
    }
}
