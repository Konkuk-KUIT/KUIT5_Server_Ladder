package ladder.creator;

import ladder.utils.position.LadderPosition;
import ladder.core.LadderSize;
import ladder.utils.position.Position;
import ladder.core.Row;

import java.util.HashSet;
import java.util.Random;

public class LadderAutoCreatorImpl implements LadderCreator {

    private final Row[] rows;
    private final LadderSize ladderSize;

    public LadderAutoCreatorImpl(LadderSize ladderSize) {
        this.ladderSize = ladderSize;

        rows = new Row[ladderSize.getRow().getNumber()];
        for (int i = 0; i < ladderSize.getRow().getNumber(); i++) {
            rows[i] = new Row(ladderSize.getCol());
        }
        autoDrawLine();
    }

    @Override
    public void drawLine(LadderPosition ladderPosition) {
        rows[ladderPosition.getRow().getValue()].drawLine(ladderPosition.getCol());
    }

    @Override
    public Row[] getRows() {
        return rows;
    }

    private void autoDrawLine() {
        HashSet<LadderPosition> lineCnt = new HashSet<>();
        Random rand = new Random();

        while (lineCnt.size() < numberOfLines()) {
            LadderPosition linePosition = getRandomLineNum(rand);
            if (linePosition == null) continue;

            lineCnt.add(linePosition);
        }
    }

    private int numberOfLines() {
        return (int) (ladderSize.getSize() * 0.3);
    }

    private LadderPosition getRandomLineNum(Random rand) {
        Position row = Position.from(rand.nextInt(rows.length));
        Position col = Position.from(rand.nextInt(rows[0].getNodes().length - 1));
        LadderPosition linePosition = LadderPosition.of(row, col);

        if (!canDrawLine(linePosition)) {
            return null;
        }
        return linePosition;
    }

    private boolean canDrawLine(LadderPosition linePosition) {
        try {
            drawLine(linePosition);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}
