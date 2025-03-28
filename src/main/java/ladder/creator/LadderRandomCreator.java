package ladder.creator;

import ladder.LadderPosition;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;

public class LadderRandomCreator implements LadderCreatorInterface{
    private final Row[] rows;

    public LadderRandomCreator(LadderSize ladderSize) {
        rows = new Row[ladderSize.getRowSize()];
        for (int i = 0; i < ladderSize.getRowSize(); i++) {
            rows[i] = new Row(ladderSize.getColumnSize());
        }
        createRandomPositionLines(ladderSize);
    }

    private void createRandomPositionLines(LadderSize ladderSize) {
        int lineCount = ladderSize.getLineCount();
        HashSet<LadderPosition> positionSet = new HashSet<>();
        Random random = new Random();

        while (positionSet.size() < lineCount) {
            Position startPositionX = Position.from(random.nextInt(ladderSize.getRowSize() - 1));
            Position startPositionY = Position.from(random.nextInt(ladderSize.getColumnSize().getNumber() - 1));

            addLadderPositionToHashset(startPositionX, startPositionY, positionSet);
        }
    }

    private void addLadderPositionToHashset(Position startPositionX, Position startPositionY, HashSet<LadderPosition> positionSet) {
        if (validateAndDrawLine(startPositionX, startPositionY)){
            LadderPosition ladderPosition = LadderPosition.of(startPositionX, startPositionY);
            positionSet.add(ladderPosition);
        }
    }

    private boolean validateAndDrawLine(Position startPositionX, Position startPositionY) {
        // 그릴 수 없는 위치라는 예외가 반환되면, 무시하고 다시 반복
        try {
            // Row 의 drawLineValidateDrawLinePosition 에서 그릴수 있는 위치인지 검증함
            drawLine(startPositionX, startPositionY);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    @Override
    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLine(col);
    }

    @Override
    public Row[] getRows() {
        return rows;
    }
}
