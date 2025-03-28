import creator.LadderCreator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {

    private final Ladder ladder;
    private final LadderSize ladderSize;
    private final Random random = new Random();


    public RandomLadderCreator(Ladder ladder, LadderSize ladderSize) {
        this.ladder = ladder;
        this.ladderSize = ladderSize;
    }

    @Override
    public void drawLine() {
        int maxLine = ladderSize.LadderMaxSize();
        int rows = ladderSize.getRowCount();
        int cols = ladderSize.getPersonCount() - 1;

        Set<String> drawnLine = new HashSet<>();

        checkDrawnLine(drawnLine, maxLine, rows, cols);

    }

    private void checkDrawnLine(Set<String> drawnLine, int maxLine, int rows, int cols) {
        while (drawnLine.size() < maxLine) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            String key = row + "," + col;
            if (drawnLine.contains(key)) continue;
            validDrawLine(drawnLine, row, col, key);
        }
    }

    private void validDrawLine(Set<String> drawnLine, int row, int col, String key) {
        try {
            ladder.drawLine(row, col);
            drawnLine.add(key);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
    }
}
