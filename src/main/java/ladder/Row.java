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



    public String nodeToString(final int row, final LadderPosition ladderPosition){
        StringBuilder sb = new StringBuilder();
        Position origin = Position.from(0);

        for (int i = 0 ; i<nodes.length ; i++) {
            Position tempPosition = Position.from(origin.getValue());
            nodes[i].move(tempPosition);

            if(origin.isSmallerThan(tempPosition.getValue())){
                sb.append(" 1");
            }

            if(origin.isBiggerThan(tempPosition.getValue())){
                sb.append("-1");
            }

            if(origin.isSameAs(tempPosition.getValue())) {
                sb.append(" 0");
            }

            if(ladderPosition.isSameAs(row,i)){
                sb.append("*");
                continue;
            }

            sb.append(" ");
            origin.next();
        }
        return sb.toString();
    }

    public int getNodelength() {
        return nodes.length;
    }

}