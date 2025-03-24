package ladderGame;

public class LadderPrinter {
    private static final char rowLine = '│';
    private static final char columnLine = '─';
    private static final char moveLine = '↓';
    private static final char space = ' ';

    public static void printLadder(LadderGame ladderGame, Position currentPosition) {
        for(int row = ladderGame.getHeight(); row >= 1; row--) {
            printColumn(ladderGame, currentPosition, row);
            System.out.println();
        }
        System.out.println();

    }

    private static void printColumn(LadderGame ladderGame, Position currentPosition, int currentRow) {
        for (int column = 1; column <= ladderGame.getWidth(); column++) {
            printRowCell(currentPosition, currentRow, column);
            if (column < ladderGame.getWidth())
                printColumnCell(ladderGame, currentRow, column);
        }
    }

    private static void printRowCell(Position currentPosition, int currentRow, int currentColumn) {
        if (currentPosition.getRow() == currentRow && currentPosition.getColumn() == currentColumn) {
            System.out.print(moveLine);
            return;
        }

        System.out.print(rowLine);
    }

    private static void printColumnCell(LadderGame ladderGame, int currentRow, int currentColumn) {
        if (ladderGame.hasLine(new Position(currentRow, currentColumn))) {
            System.out.print(columnLine);
            return;
        }

        System.out.print(space);
    }
}
