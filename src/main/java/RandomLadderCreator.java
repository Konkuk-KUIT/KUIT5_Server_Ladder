import java.util.*;

public class RandomLadderCreator implements LadderCreator {

    @Override
    public List<Row> createLadder(LadderSize ladderSize) {
        List<Row> rows = new ArrayList<>();
        Random random = new Random();
        Set<Integer> usedPositions = new HashSet<>();

        int numberOfLines = ladderSize.calculateNumberOfLines();

        for (int y = 0; y < ladderSize.getNumberOfRows(); y++) {
            List<Boolean> points = new ArrayList<>(Collections.nCopies(ladderSize.getNumberOfPersons() - 1, false));

            int linesAdded = 0;
            while (linesAdded < numberOfLines) {
                int randomPosition = random.nextInt(ladderSize.getNumberOfPersons() - 1);

                // 중복 라인 방지
                if (usedPositions.contains(randomPosition)) {
                    continue;
                }

                // 라인 추가 가능하면 추가
                if (isLineValid(randomPosition, points)) {
                    points.set(randomPosition, true);
                    usedPositions.add(randomPosition);
                    linesAdded++;
                }
            }
            rows.add(new Row(points));
        }
        return rows;
    }

    private boolean isLineValid(int position, List<Boolean> points) {
        if (position > 0 && points.get(position - 1)) {
            return false;
        }
        if (position < points.size() - 1 && points.get(position + 1)) {
            return false;
        }
        return !points.get(position);
    }
}