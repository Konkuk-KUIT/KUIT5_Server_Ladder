package ladder;

import static ladder.Direction.*;

public class Node {

    private Direction direction;
    private boolean star = false;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void showNode() {
        System.out.print(direction.getValue() + (star ? "* " : " "));
        star = false;
    }

    public void makeStar(){
        star = true;
    }

    public void move(Position position) {
        makeStar();
        if (isRight()) {
            position.next();
            return;
        }
        if (isLeft()) {
            position.prev();
            return;
        }
    }

    public void setRightNode() {
        direction = RIGHT;
    }

    public void setLeftNode() {
        direction = LEFT;
    }

    public boolean isAlreadySetDirection() {
        return !isNone();
    }

    private boolean isRight() {
        return direction == RIGHT;
    }

    private boolean isLeft() {
        return direction == LEFT;
    }

    private boolean isNone() {
        return direction == NONE;
    }
}
