import exception.ExceptionMessage;

public class LadderRunnerWithPrinter {

    private final LadderPrinter printer;

    private LadderRunnerWithPrinter(LadderPrinter printer) {
        this.printer = printer;
    }

    public static LadderRunnerWithPrinter from(LadderPrinter printer) {
        return new LadderRunnerWithPrinter(printer);
    }

    public int run(Ladder ladder, NaturalNumber start) {
        if (!ladder.isValidStartPosition(start)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }

        int[][] rows = ladder.getRows();
        LadderPosition position = LadderPosition.of(0, start.getValue() - 1);

        printer.printWithMarker(position, Time.BEFORE);

        while (position.getX() < rows.length) {
            int direction = rows[position.getX()][position.getY()];
            LadderPosition moved = position.move(direction);
            printer.printWithMarker(moved, Time.AFTER);

            LadderPosition down = moved.down();
            if (down.getX() < rows.length) {
                printer.printWithMarker(down, Time.BEFORE);
            }

            position = down;
        }

        return position.getY() + 1;
    }
}
