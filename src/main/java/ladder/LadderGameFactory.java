package ladder;

import ladder.creator.LadderCreator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static ladder.ExceptionMessage.INVALID_DRAW_POSITION;

public class LadderGameFactory {

    public static LadderGame createRandomLadderGame(LadderCreator ladderCreator) {
        LadderSize size = ladderCreator.getLadderSize();
        int numOfLadderLine = size.calculateAutoLineCount();
        int rowLimit = size.getNumberOfRow();
        int colLimit = size.getNumberOfPerson() - 1;

        Set<String> drawnLine = new HashSet<>();
        Random random = new Random();

        while (drawnLine.size() < numOfLadderLine) {
            Position rowIndex = Position.from(random.nextInt(rowLimit));
            Position colIndex = Position.from(random.nextInt(colLimit));
            String curPosition = rowIndex + ", " + colIndex;

            if (drawnLine.contains(curPosition)) {
                continue;
            }

            try {
                ladderCreator.drawLine(rowIndex, colIndex);
                drawnLine.add(curPosition);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }

        return new LadderGame(ladderCreator);
    }
}
