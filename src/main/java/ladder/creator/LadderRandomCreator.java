package ladder.creator;

import ladder.LadderPosition;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

import java.util.HashSet;
import java.util.Random;

public class LadderRandomCreator implements LadderCreator {
    //private final Row[] rows;
    private final LadderBasicCreator ladderBasicCreator;

    public LadderRandomCreator(LadderSize ladderSize) {
        //this.rows = this.ladderCreator.getRows(); // rows 배열을 LadderBasicCreator 에서 가져옴
        this.ladderBasicCreator = new LadderBasicCreator(ladderSize); // LadderBasicCreator 인스턴스 생성
        createRandomPositionLines(ladderSize);
    }

    private void createRandomPositionLines(LadderSize ladderSize) {
        int lineCount = ladderSize.getLineCount();
        HashSet<LadderPosition> positionSet = new HashSet<>();
        Random random = new Random();

        while (positionSet.size() < lineCount) {
            Position startPositionX = Position.from(random.nextInt(ladderSize.getRowSize()));
            Position startPositionY = Position.from(random.nextInt(ladderSize.getColumnSize().getNumber() - 1)); // 맨 마지막 column 이 line 시작점이 될 순 없으니까

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
        this.ladderBasicCreator.drawLine(row, col);
    }

    @Override
    public Row[] getRows() {
        return this.ladderBasicCreator.getRows();
    }
}
