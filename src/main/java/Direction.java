public enum Direction {
    RIGHT(1), LEFT(-1), NONE(0);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}