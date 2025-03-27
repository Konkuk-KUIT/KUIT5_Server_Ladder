package ladder.creator;

import ladder.GreaterThanOne;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private final Row[] rows;

    public RandomLadderCreator(LadderSize ladderSize) {
        GreaterThanOne numberOfRow = ladderSize.getNumberOfRow();
        GreaterThanOne numberOfPerson = ladderSize.getNumberOfPerson();

        rows = new Row[numberOfRow.getNumber()];
        for (int i = 0; i < numberOfRow.getNumber(); i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    @Override
    public void drawLine(Position row, Position col) {
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    public void drawRandomLines(LadderSize ladderSize){
        HashSet<String> drawnLines = new HashSet<>();
        int size = ladderSize.getMultipledSize();
        int numberOfLine = (int)(size*0.3);

        while (drawnLines.size() < numberOfLine) {
            addRandomLine(drawnLines, ladderSize);
        }
    }

    private void addRandomLine(HashSet<String> drawnLines, LadderSize ladderSize){
        Random rand = new Random();
        int row = rand.nextInt(ladderSize.getNumberOfRow().getNumber());
        int col = rand.nextInt(ladderSize.getNumberOfPerson().getNumber()-1);

        String key = row + "-" + col; // HashSet에서 중복 방지를 위한 key

        if (drawnLines.contains(key))
            return;
        try {
            drawLine(Position.from(row), Position.from(col));
            drawnLines.add(key);
        } catch (IllegalArgumentException e) {}
    }
}
