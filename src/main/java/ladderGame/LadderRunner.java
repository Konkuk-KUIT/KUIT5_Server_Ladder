package ladderGame;

public class LadderRunner {
    private LadderGame ladderGame;
    private boolean debug;

    public LadderRunner(LadderGame ladderGame, boolean debug) {
        this.ladderGame = ladderGame;
        this.debug = debug;
    }

    public int run(PositiveNumber startNumber) {
        Position position = new Position(ladderGame.getHeight(), startNumber.getNumber(), ladderGame.getHeight(), ladderGame.getWidth());

        if (debug)
            LadderPrinter.printLadder(ladderGame, position);

        while(canMoveDown(position)) {
            position = move(position);
        }

        position = moveHorizontal(position);

        return position.getColumn();
    }

    private Position move(Position position) {
        position = moveHorizontal(position);

        if (canMoveDown(position)) {
            position = moveDown(position);
        }
        return position;
    }

    private boolean canMoveDown(Position position) {
        return position.getRow() > 1;
    }

    private boolean canMoveLeft(Position position) {
        return (position.getColumn() > 1 && ladderGame.hasLine(new Position(position.getRow(), position.getColumn() - 1, ladderGame.getHeight(), ladderGame.getWidth())));
    }

    private boolean canMoveRight(Position position) {
        return (position.getColumn() < ladderGame.getWidth() && ladderGame.hasLine(position));
    }

    private Position moveLeft(Position currentPosition) {
        Position newPosition = new Position(currentPosition.getRow(), currentPosition.getColumn() - 1, ladderGame.getHeight(), ladderGame.getWidth());
        if (debug)
            LadderPrinter.printLadder(ladderGame, newPosition);
        return newPosition;
    }

    private Position moveRight(Position currentPosition) {
        Position newPosition = new Position(currentPosition.getRow(), currentPosition.getColumn() + 1, ladderGame.getHeight(), ladderGame.getWidth());
        if (debug)
            LadderPrinter.printLadder(ladderGame, newPosition);
        return newPosition;
    }

    private Position moveDown(Position currentPosition) {
        Position newPosition = new Position(currentPosition.getRow() - 1, currentPosition.getColumn(), ladderGame.getHeight(), ladderGame.getWidth());
        if (debug)
            LadderPrinter.printLadder(ladderGame, newPosition);
        return newPosition;
    }

    private Position moveHorizontal(Position position) {
        if (canMoveRight(position)) { // move right
            return moveRight(position);
        }

        if (canMoveLeft(position)) { // move left
            return moveLeft(position);
        }

        return new Position(position);
    }
}
