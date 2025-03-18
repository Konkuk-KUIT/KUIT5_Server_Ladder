public class Position {
    int x;
    int y;
    public Position(int x, int y) {}
    public static boolean DownZero(Position p) {
        return (p.x < 0 || p.y < 0);
    }
}
