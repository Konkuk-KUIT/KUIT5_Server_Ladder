import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// 사다리에 랜덤으로 선을 그리는 클래스
public class LadderRandomCreator {
    private final Ladder ladder;
    private static final double LINE_DENSITY = 0.3;

    private LadderRandomCreator(Ladder ladder){
        this.ladder = ladder;
    }

    public static LadderRandomCreator createRandomLadderGame(Ladder ladder){
        randomDrawLines(ladder);
        return new LadderRandomCreator(ladder);
    }

    private static void randomDrawLines(Ladder ladder) {
        int height = ladder.getLadderRows().getHeight(); // row + 1
        int width = ladder.getLadderRows().getWidth();   // numberOfPerson + 1

        int maxLines = (int) ((height - 1) * (width - 1) * LINE_DENSITY);

        // 이미 그려진 것은 HashSet에 저장.
        Set<String> drawnPositions = new HashSet<>();
        Random random = new Random();

        // HashSet에 사다리 행*열 *0.3 를 넘지 않도록 선을 그린다.
        while (drawnPositions.size() < maxLines) {
            randomDrawOneLine(ladder, random, height, width, drawnPositions);
        }
    }

    private static void randomDrawOneLine(Ladder ladder, Random random, int height, int width, Set<String> drawnPositions) {
        // 랜덤값 생성
        int row = random.nextInt(height - 1) + 1;      // 1 ~ height - 1
        int column = random.nextInt(width - 2) + 1;        // 0 ~ width - 2

        String key = row + "-" + column;

        // 이미 그려져 있으면 검증 없이 바로 리턴
        if (drawnPositions.contains(key)) return;

        try {
            ladder.tryToDrawLine(NaturalNumber.of(row), NaturalNumber.of(column));
            drawnPositions.add(key);
        } catch (IllegalArgumentException e) {
            // 그릴 수 없는 예외 상황 (겹치는 선 또는 마지막 열 등)
        }
    }
}
