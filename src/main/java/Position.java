public class Position {

    private final int start;
    private final int end;

    private Position(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private static void validStartEnd(int start, int end) {
        if (start == end) {
            throw new IllegalArgumentException(LadderException.SAME_NUMBER.getMessage());
        }
        if (Math.abs(start - end) != 1) {
            throw new IllegalArgumentException(LadderException.InvalidLinePositionException.getMessage());
        }
    }

    public static Position of(int start, int end) {
        validStartEnd(start, end);
        return new Position(start, end);
    }


}
