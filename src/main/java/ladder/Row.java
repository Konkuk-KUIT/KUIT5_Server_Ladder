package ladder;

import static ladder.Direction.*;
import static ladder.ExceptionMessage.*;

// 사다리 한줄을 담당, 선을 긋거나 위치 이동
public class Row {
    private final Node[] nodes;
    private static final String CURRENT_MARKER = "*";

    // 특정 행에서의 사람의 위치를 NONE으로 초기화하기. (기본 틀 만들기!)
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

    public String printARow(LadderPosition currentPosition, int currRowY) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size(); i++) {
            Direction dir = getDirection(i);
            sb.append(dir.getValue())
                    .append(currentPosition.isInARightPosition(i, currRowY) ? CURRENT_MARKER : "")
                    .append(" ");
//            if (currentPosition.isInARightPosition(i, currRowY)) {
//                sb.append(dir.getValue()).append("*");
//            } else {
//                sb.append(dir.getValue());
//            }
//            sb.append(" ");
        }
        return sb.toString();
    }

    private int size() {
        return nodes.length;
    }

    private Direction getDirection(int index) {
        return nodes[index].getDirection();
    }
}