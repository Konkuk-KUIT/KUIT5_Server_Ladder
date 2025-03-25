package ladder;

import static ladder.Direction.*;
import static ladder.ExceptionMessage.*;

public class Row {
    private final Node[] nodes;

    public Row(GreaterThanOne numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.from(NONE);
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        setDirectionBetweenNextPosition(startPosition);
    }

    public void nextPosition(Position position) {
        validatePosition(position);

        nodes[position.getValue()].move(position);
    }

    private void setDirectionBetweenNextPosition(Position position) {
        nodes[position.getValue()].setRightNode();
        position.next();
        nodes[position.getValue()].setLeftNode();
    }

    private void validatePosition(Position position) {
        if (isInvalidPosition(position) ) {
            throw new IllegalArgumentException(INVALID_POSITION.getMessage());
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePosition(startPosition);
        if (isLineAtPosition(startPosition) || isLineAtNextPosition(startPosition)) {
            throw new IllegalArgumentException(INVALID_DRAW_POSITION.getMessage());
        }
    }

    private boolean isInvalidPosition(Position position) {
        return position.isBiggerThan(nodes.length - 1) ;
    }

    private boolean isLineAtPosition(Position position) {
        return nodes[position.getValue()].isAlreadySetDirection();
    }

    private boolean isLineAtNextPosition(Position position) {
        position.next();
        boolean lineAtPosition = isLineAtPosition(position);
        position.prev();
        return lineAtPosition;
    }

    // 일반 row 를 출력하는 메서드
    public void printRowWithoutCurrentPosition() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.getNodeDirection()).append(" ");
        }
        System.out.println(sb);
    }

    // 현재 run 중인 row 를 출력하는 메서드
    public void printRowWithCurrentPosition(LadderPosition ladderPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            printStar(ladderPosition, i, sb);
        }
        System.out.println(sb);
    }

    // row 안에서 star 를 찍는 메서드
    private void printStar(LadderPosition ladderPosition, int i, StringBuilder sb) {
        if (ladderPosition.equalToPositionY(i)) {
            sb.append(nodes[i].getNodeDirection()).append("* ");
            return;
        }
        sb.append(nodes[i].getNodeDirection()).append(" ");
    }
}