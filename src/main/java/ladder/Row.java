package ladder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        if (isInvalidPosition(position)) {
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
        return position.isBiggerThan(nodes.length - 1);
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

    public String rowToString() {
        return Stream.of(nodes) // Node 배열을 스트림으로 변환
                .map(node -> String.valueOf(node.getDirectionValue())) // 각 노드의 Direction 값의 value 값을 문자열로 반환
                .collect(Collectors.joining(" ")); // 변환한 값들을 공백으로 연결해 문자열로 만듦
    }

    public String rowToStringWithStar(int ladderPositionX) {
        return IntStream.range(0, nodes.length)
                .mapToObj(i -> (i == ladderPositionX) ? nodes[i].valueToString() + "*" : String.valueOf(nodes[i]))
                .reduce((a, b) -> a + " " + b) // 문자열 합치기
                .orElse(""); // 값이 없을 경우 빈 문자열 반환
    }

}