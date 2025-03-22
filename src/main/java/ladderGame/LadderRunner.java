package ladderGame;

public class LadderRunner {
    private Ladder ladder;
    private boolean debug;

    public LadderRunner(Ladder ladder, boolean debug) {
        this.ladder = ladder;
        this.debug = debug;
    }

    public int run(PositiveNumber startNumber) {
        Position position = new Position(ladder.getHeight(), startNumber.getNumber());

        if (debug)
            LadderPrinter.printLadder(ladder, position);

        while(canMoveDown(position)) {
            position = move(position);
        }

        int row = position.getRow();
        int column = position.getColumn();

        if (column < ladder.getWidth() && ladder.hasLine(position)) {
            return moveRight(position).getColumn();
        }

        if (column > 1 && ladder.hasLine(new Position(row, column - 1))) // move left
            return moveLeft(position).getColumn();

        return column;
    }

    private Position move(Position currentPosition) {
        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();

        if (column < ladder.getWidth() && ladder.hasLine(currentPosition)) { // move right
            return moveRight(currentPosition);
        }

        if (column > 1 && ladder.hasLine(new Position(row, column - 1))) { // move left
            return moveLeft(currentPosition);
        }

        return moveDown(currentPosition);

    }

    private boolean canMoveDown(Position currentPosition) {
        return currentPosition.getRow() > 1;
    }

    private Position moveLeft(Position currentPosition) {
        currentPosition = new Position(currentPosition.getRow(), currentPosition.getColumn() - 1);
        if (debug)
            LadderPrinter.printLadder(ladder, currentPosition);

        if (canMoveDown(currentPosition)) { // move down
            currentPosition = moveDown(currentPosition);
        }

        return currentPosition;
    }

    private Position moveRight(Position currentPosition) {
        currentPosition = new Position(currentPosition.getRow(), currentPosition.getColumn() + 1);
        if (debug)
            LadderPrinter.printLadder(ladder, currentPosition);

        if (canMoveDown(currentPosition)) { // move down
            currentPosition = moveDown(currentPosition);
        }

        return currentPosition;
    }

    private Position moveDown(Position currentPosition) {
        currentPosition = new Position(currentPosition.getRow() - 1, currentPosition.getColumn());
        if (debug)
            LadderPrinter.printLadder(ladder, currentPosition);
        return currentPosition;
    }


}
