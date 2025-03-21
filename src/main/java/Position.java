public class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean LessThenZero(Position p) {
        return (p.x < 0 || p.y < 0);
    }

}
