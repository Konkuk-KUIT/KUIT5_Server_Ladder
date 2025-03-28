public enum Direction {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private final int directions;

    Direction(int directions) {
        this.directions = directions;
    }

    public int getValue(){
        return directions;
    }
}
