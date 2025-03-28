import javax.swing.text.Position;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {
    private final LadderSize laddersize;
    private final ManualLadderCreator manualcreator;
    private final Random random = new Random();

    public RandomLadderCreator(LadderSize laddersize) {
        this.laddersize = laddersize;
        this.manualcreator = new ManualLadderCreator(laddersize);
    }

    @Override
    public Ladder create() {
        return manualcreator.create();
    }

    public Ladder RandomLineGenerate() {
        Ladder ladder = create();
        Set<LadderPosition> drawLines = new HashSet<>();
        int targetLineCount = laddersize.getLineCount();

        while (drawLines.size() < targetLineCount) {
            int row = random.nextInt(laddersize.getNumberOfRow());
            int col = random.nextInt(laddersize.getNumberOfPerson()-1);

            LadderPosition position = new LadderPosition(row,col);
            if (drawLines.contains(position))
                continue;

            try {
                drawLine(ladder,row,col);
                drawLines.add(position);
            } catch (IllegalArgumentException e) {}
        }

        return ladder;
    }

    @Override
    public void drawLine(Ladder ladder, int row, int col) {
        manualcreator.drawLine(ladder,row,col);
    }

}
