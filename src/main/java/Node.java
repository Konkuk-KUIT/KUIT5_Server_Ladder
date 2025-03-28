public class Node {
    private Direction state;

    private Node(Direction state) {
        this.state = state;
    }

    public static Node of(Direction state) {
        return new Node(state);
    }

    public void setRight() {
        this.state = Direction.RIGHT;
    }

    public void setLeft() {
        this.state = Direction.LEFT;
    }

    public void moveColumn(Position start) {
        start.move(state);
    }

    //test코드 용 state 반환 메서드
    public Direction getState() {
        return this.state;
    }

}