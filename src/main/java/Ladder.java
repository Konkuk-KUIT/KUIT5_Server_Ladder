import java.util.Random;

public class Ladder {
    private final Positions positions;

    private Ladder(int row, int numberOfPerson) {
        this.positions = new Positions(row, numberOfPerson);
    }

    public static Ladder createEmptyLadder(NaturalNumber row, NaturalNumber numberOfPerson) {
        return new Ladder(row.getNumber(), numberOfPerson.getNumber());
    }

    public static Ladder createRandomLadder(NaturalNumber row, NaturalNumber numberOfPerson) {
        Ladder ladder = new Ladder(row.getNumber(), numberOfPerson.getNumber());
        ladder.drawRandomLine();

        return ladder;
    }

    // 사다리타기 시작
    public int run(int startIndex){
        // 시작 좌표 입력이 잘못되었을 경우에는 throw
        if (startIndex < 0 || startIndex >= positions.getMaxCol()) {
            throw new IllegalArgumentException(ExceptionMessage.START_INDEX_OUT_OF_BOUNDS.getMessage());
        }

        return processLadder(startIndex);
    }

    // 특정 위치에 다리를 그리는 public 메서드
    public void drawLine(NaturalNumber naturalRow, NaturalNumber naturalCol) {
        int row = naturalRow.getNumber();
        int col = naturalCol.getNumber();

        if (row >= positions.getMaxRow() || col >= positions.getMaxCol()) {
            throw new IllegalArgumentException(ExceptionMessage.POSITION_INVALID.getMessage());
        }

        // 연속된 다리 방지 (왼쪽에 다리가 있으면 생성 X)
        if (col > 0 && positions.getPosition(row, col - 1).hasBridge()) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_UNREPEATABLE.getMessage());
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

    // 사다리를 탈 때, 아래로 내려오는 로직
    private int processLadder(int startIndex) {
        int currentIndex = startIndex;
        for (int i = 0; i < positions.getMaxRow(); i++) {
            currentIndex = processRow(i, currentIndex);
        }

        return currentIndex;
    }

    // 사다리를 탈 때, 좌 우로 이동하는 로직
    // 현재 row 좌표에서 컬럼 이동을 한다면 index +- 1(사다리타기), 컬럼 이동을 하지 않는다면 index값(아래방향으로 내려옴)을 반환
    private int processRow(int currentRow, int currentIndex) {
        // 왼쪽으로 이동하는 경우
        // 최좌단에 위치하지 않고, 왼쪽 좌표의 배열값이 1인경우
        if (currentIndex > 0 && positions.getPosition(currentRow, currentIndex - 1).hasBridge()) {
            return currentIndex - 1;
        }

        // 오른쪽으로 이동하는 경우
        // 최우단에 위치하지 않고, 현재 좌표의 배열값이 1인 경우
        if (currentIndex < positions.getMaxCol() - 1 && positions.getPosition(currentRow, currentIndex).hasBridge()) {
            return currentIndex + 1;
        }

        // 좌우 이동 없이 아래로 이동하는 경우
        return currentIndex;
    }

    public Positions getPositions() {
        return positions;
    }
}
