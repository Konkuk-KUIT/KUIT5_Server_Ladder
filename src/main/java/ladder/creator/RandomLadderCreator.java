package ladder.creator;

import ladder.GreaterThanOne;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderGenerator {
    private final ManualLadderCreator manualLadderCreator;

    public RandomLadderCreator(GreaterThanOne rowCount, GreaterThanOne personCount) {
        this.manualLadderCreator = new ManualLadderCreator(rowCount, personCount);
        generateRandomLines(rowCount.getNumber(), personCount.getNumber());
    }

    private void generateRandomLines(int rowCount, int personCount) {
        int totalLines = (int) (rowCount * personCount * 0.3);
        Set<String> usedPositions = new HashSet<>();
        Random random = new Random();

        while (usedPositions.size() < totalLines) {
            int randRow = random.nextInt(rowCount);
            int randCol = random.nextInt(personCount - 1); // 마지막 칸 제외

            String key = randRow + "," + randCol;

            if (usedPositions.contains(key)) { // 중복 방지를 위한 예외처리
                continue;
            }

            Row[] rows = manualLadderCreator.getRows();
            if (rows[randRow].canDraw(Position.from(randCol))) {
                manualLadderCreator.drawLine(Position.from(randRow), Position.from(randCol));
                usedPositions.add(key);
            }
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        manualLadderCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return manualLadderCreator.getRows();
    }
}

