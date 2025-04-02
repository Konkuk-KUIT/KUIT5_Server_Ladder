public class Node {
    private final int direction;

    private Node(int direction) {
        this.direction = direction;
    }

    public static Node of(int direction) {
        return new Node(direction);
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return String.valueOf(direction);
    }
}
