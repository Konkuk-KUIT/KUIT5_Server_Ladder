public class Position {
    private final NaturalNumber x;
    private final NaturalNumber y;

    private Position(NaturalNumber x, NaturalNumber y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(NaturalNumber x, NaturalNumber y) {
        return new Position(x,y);
    }

    public int getX() {
        return x.getNumber();
    }

    public int getY() {
        return y.getNumber();
    }

}
