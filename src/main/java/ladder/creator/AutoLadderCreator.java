package ladder.creator;

import ladder.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//프로그램이 랜덤으로 사다리를 자동으로 생성하고 그리기
public class AutoLadderCreator implements LadderCreator{
    private final UserLadderCreator userLadderCreator;

    public AutoLadderCreator(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this(LadderSize.of(numberOfRow.getNumber(), numberOfPerson.getNumber()));
    }

    public AutoLadderCreator(LadderSize laddersize) {
        userLadderCreator = new UserLadderCreator(laddersize);
        drawLadderLine(laddersize);
    }

    public void drawLadderLine(LadderSize size) {
        int numOfRandomLadderLine = size.calculateAutoLineCount();
        int rowLimit = size.getNumberOfRow();
        int colLimit = size.getNumberOfPerson() - 1;

        // LadderSIze는 user에 필드로 선언되어 있으므로 안가져와도 도미.
        Set<String> drawnLine = new HashSet<>();
        Random random = new Random();

        while (canBeAddedToSet(drawnLine, numOfRandomLadderLine)) {
            Position rowIndex = Position.from(getRandomPosition(random, rowLimit));
            Position colIndex = Position.from(getRandomPosition(random, colLimit));
            String curPosition = getCurPositionByString(rowIndex, colIndex);

            if (isSetContains(drawnLine, curPosition)) {
                continue;
            }

            try {
                userLadderCreator.drawLine(rowIndex, colIndex);
                drawnLine.add(curPosition);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    private static String getCurPositionByString(Position rowIndex, Position colIndex) {
        return rowIndex + ", " + colIndex;
    }

    private static int getRandomPosition(Random random, int rowLimit) {
        return random.nextInt(rowLimit);
    }

    private static boolean canBeAddedToSet(Set<String> drawnLine, int numOfRandomLadderLine) {
        return drawnLine.size() < numOfRandomLadderLine;
    }

    private static boolean isSetContains(Set<String> drawnLine, String curPosition) {
        return drawnLine.contains(curPosition);
    }

    @Override
    public void drawLine(Position row, Position col) {
        userLadderCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return userLadderCreator.getRows();
    }

    @Override
    public LadderSize getLadderSize() {
        return userLadderCreator.getLadderSize();
    }
}