import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLadderCreator implements LadderCreator {
    private final Random random = new Random();
    private final LadderSize ladderSize;

    public RandomLadderCreator(LadderSize ladderSize) {
        this.ladderSize = ladderSize;
    }

    @Override
    public boolean canDrawLine(Ladder ladder, int row, int col){
        try {
            ladder.validate(row, col);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void createLines(Ladder ladder){
        int rowCount = ladderSize.getNumberOfRow();
        int colCount = ladderSize.getNumberOfPerson();
        int maxLines = ladderSize.getMaxLines();

        Set<String> drawn = new HashSet<>();

        while(drawn.size() < maxLines){
            int row = random.nextInt(rowCount);
            int col = random.nextInt(colCount - 1);
            String key = row + "," + col;

            if(drawn.contains(key)) continue;

            if(canDrawLine(ladder, row, col)){
                ladder.drawLine(row, col);
                drawn.add(key);
            }
        }
    }
}
