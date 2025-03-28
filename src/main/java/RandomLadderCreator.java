import java.util.HashSet;
import java.util.Random;

public class RandomLadderCreator implements LineCreator {

    private final LadderCreator creator = LadderCreator.from();
    private final Random random = new Random();

    private RandomLadderCreator() {
    }

    public static RandomLadderCreator from() {
        return new RandomLadderCreator();
    }

    @Override
    public void drawLine(Ladder ladder, Position position) {
        creator.drawLine(ladder, position);
    }

    @Override
    public int[][] getRows(Ladder ladder) {
        return creator.getRows(ladder);
    }

    public void drawRandomLines(Ladder ladder, LadderSize size) {
        int numberOfLines = size.calculateNumberOfLines();
        HashSet<String> drawn = new HashSet<>();

        while (drawn.size() < numberOfLines) {
            int x = random.nextInt(size.getRow());
            int y = random.nextInt(size.getCol() - 1);

            Position pos = Position.of(x, y);
            String key = x + "," + y;

            try {
                if (!drawn.contains(key)) {
                    drawLine(ladder, pos);
                    drawn.add(key);
                }
            } catch (IllegalArgumentException ignored) {
            }
        }
    }
}
