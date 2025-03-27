import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private final Random random = new Random();
    private Positions positions;

    public RandomLadderCreator() {
    }

    @Override
    public Ladder createLadder(NaturalNumber row, NaturalNumber numberOfPerson) {
        Ladder ladder = Ladder.createEmptyLadder(row, numberOfPerson);
        this.positions = ladder.getPositions();
        int maxLines = (int) (row.getNumber() * numberOfPerson.getNumber() * 0.3); // 사다리 최대 라인 수

        int linesAdded = 0;
        while (linesAdded < maxLines) {
            int randomRow = random.nextInt(row.getNumber()); // 랜덤 행 선택
            int randomCol = random.nextInt(numberOfPerson.getNumber() - 1); // 랜덤 열 선택 (최우단 제외)

            try {
                drawLine(new NonNegativeNumber(randomRow), new NonNegativeNumber(randomCol));
                linesAdded++;
            } catch (IllegalArgumentException e) {
                // 연속된 다리 예외 발생 시 무시하고 다시 시도
            }
        }

        return ladder;
    }

    // 특정 위치에 다리를 그리는 public 메서드
    public void drawLine(NonNegativeNumber nonNegativeRow, NonNegativeNumber nonNegativeCol) {
        int row = nonNegativeRow.getNumber();
        int col = nonNegativeCol.getNumber();

        if (row >= positions.getMaxRow() || col >= positions.getMaxCol()) {
            throw new IllegalArgumentException(ExceptionMessage.POSITION_INVALID.getMessage());
        }

        // 연속된 다리 방지 (좌우에 다리가 있으면 생성 X)
        if (col > 0 && (positions.getPosition(row, col - 1).hasBridge())) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_UNREPEATABLE.getMessage());
        }
        if (positions.getPosition(row, col + 1).hasBridge()) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_UNREPEATABLE.getMessage());
        }

        // 동일좌표 다리 재생성 방지
        if (positions.getPosition(row, col).hasBridge()) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_ALREADY_EXISTS.getMessage());
        }

        positions.getPosition(row, col).setHasBridge(true);
    }

    // 사다리의 구조를 결정하는 메소드. Ladder 인스턴스가 생성됨과 동시에 배열의 값을 초기화한다.
    // 0 : row[row][col]값에 해당하는 좌표에 다른 컬럼으로 이동하는 다리가 없음
    // 1 : 다리가 있음
    private void drawRandomLine(){
        for (int i = 0; i < positions.getMaxRow(); i++) {
            drawRandomBridge(i);
        }
    }

    private void drawRandomBridge(int rowIndex){
        Random random = new Random();
        for (int j = 0; j < positions.getMaxCol(rowIndex) - 1; j++) { // 마지막 열은 오른쪽으로 뻗어나가는 다리를 생성할 수 없다
            boolean canCreateBridge = random.nextBoolean();

            // 왼쪽에 다리가 있을 경우 현재 칸에 다리 없도록 설정
            if (j > 0 && positions.getPosition(rowIndex, j - 1).hasBridge()) {
                positions.getPosition(rowIndex, j).setHasBridge(false);
            } else if (canCreateBridge) { // 연속된 다리가 없는 경우에 대해 랜덤으로 다리 생성
                positions.getPosition(rowIndex, j).setHasBridge(true);
            }
        }
    }

    public void resetLadder(){
        for (int i = 0; i < positions.getMaxRow(); i++) {
            for (int j = 0; j < positions.getMaxCol(); j++) {
                positions.getPosition(i, j).setHasBridge(false);
            }
        }
    }

    public Positions getPositions() {
        return positions;
    }
}
