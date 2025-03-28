package ladderGame;

public class LadderPrinter {
    private static final char rowLine = '│';
    private static final char columnLine = '─';
    private static final char moveLine = '↓';
    private static final char space = ' ';

    public static void printLadder(LadderGame ladderGame, Position position) {
        for(int row = ladderGame.getHeight(); row >= 1; row--) {
            printRow(ladderGame, position, row);
            System.out.println();
        }
        System.out.println();

    }

    private static void printRow(LadderGame ladderGame, Position position, int currentRow) {
        for (int column = 1; column <= ladderGame.getWidth(); column++) {
            printRowCell(position, currentRow, column);
            if (column < ladderGame.getWidth())
                printColumnCell(ladderGame, currentRow, column);
        }
    }

    private static void printRowCell(Position position, int currentRow, int currentColumn) {
        if (position.getRow() == currentRow && position.getColumn() == currentColumn) {
            System.out.print(moveLine);
            return;
        }

        System.out.print(rowLine);
    }

    private static void printColumnCell(LadderGame ladderGame, int currentRow, int currentColumn) {
        if (ladderGame.hasLine(new Position(currentRow, currentColumn, ladderGame.getHeight(), ladderGame.getWidth()))) {
            System.out.print(columnLine);
            return;
        }

        System.out.print(space);
    }
}
