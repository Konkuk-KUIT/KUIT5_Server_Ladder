import java.util.Random;

public class RandomLadderCreator implements LadderCreator{
    private final Random random = new Random();
    @Override
    public void create(Ladder ladder) {
        int maxLine = ladder.getCountRandomLine();
        int numberOfPerson = ladder.getNumberOfPerson();
        int levels = ladder.getRowSize();

        int count = 0;
        while (count < maxLine) {
            int line = random.nextInt(numberOfPerson - 1) + 1;
            int level = random.nextInt(levels) + 1;
            try {
                ladder.drawLine(line, level);
                count++;
            } catch (IllegalArgumentException e) {
                // 이미 선이 그려진 경우 다시 시도
            }
        }
    }
}
