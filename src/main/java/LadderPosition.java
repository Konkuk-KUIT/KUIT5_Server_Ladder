public class LadderPosition {
    private int x;
    private int y;

    private LadderPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static LadderPosition create(int x, int y) {
        validateIsNotNegative(x);
        validateIsNotNegative(y);

        return new LadderPosition(x, y);
    }

    private static void validateIsNotNegative(int position) {
        if(position < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALD_POSITION.getMessage());
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public LadderPosition moveDown() {
        return LadderPosition.create(x, y + 1);
    }

    public LadderPosition moveBreadthwise(int movedIndex) {
        return  LadderPosition.create(movedIndex, y);
    }

    public boolean checkY(int levelIndex) {
        return y == levelIndex;
    }
}
