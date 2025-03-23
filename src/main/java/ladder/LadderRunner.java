package ladder;

// 사다리의 위치를 이동시키는 로직 담당
public class LadderRunner {

    private static final String BEFORE_STATE = "Before";
    private static final String AFTER_STATE = "After";

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    // 실제 사다리 이동 로직 실행, 한칸씩 내려가며 이동 처리
    // 이동 규칙에 따라 실제 위치를 바꾼다! (사다리를 타는 사람)
    public int run(Position position) {
        // 각 행을 순차적으로 내려가며 Row의 nextPosition을 호출.
        for (int i = 0; i < rows.length; i++) {
            System.out.println(BEFORE_STATE);
            printOutResultsOfRows(position, i);

            rows[i].nextPosition(position);

            System.out.println(AFTER_STATE);
            printOutResultsOfRows(position, i);
        }
        return position.getValue();
    }

    // row들마다 돌아가며 출력하는 메서드.
    private void printOutResultsOfRows(Position position, int currentRowIndex) {
        LadderPosition ladderPosition = getLadderPosition(position, currentRowIndex);
        for (int j = 0; j < rows.length; j++) {
            System.out.println(rows[j].printARow(ladderPosition, j));
        }
        System.out.println();
    }

    private static LadderPosition getLadderPosition(Position currColIndex, int currentRowIndex) {
        return LadderPosition.of(currColIndex.getValue(), currentRowIndex);
    }
}
