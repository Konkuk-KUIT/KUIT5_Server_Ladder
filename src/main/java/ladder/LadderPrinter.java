package ladder;

public class LadderPrinter {
    private final Row[] rows;

    public LadderPrinter(Row[] rows) {
        this.rows = rows;
    }

    public void printBefore(LadderPosition ladderPosition) {
        System.out.println("Before");
        printLadderWithCurrentPosition(ladderPosition);
    }

    public void printAfter(LadderPosition ladderPosition) {
        System.out.println("After");
        printLadderWithCurrentPosition(ladderPosition);
    }

    // 현재 위치한 곳을 표시하며 ladder 를 출력하는 메서드
    private void printLadderWithCurrentPosition(LadderPosition ladderPosition) {
        for (int i = 0; i < rows.length; i++) {
            checkLadderPositionRow(ladderPosition, i);
        }
    }

    // 현재 위치한 row 인지 판단하여, 알맞은 row printing 메서드를 호출하는 메서드
    private void checkLadderPositionRow(LadderPosition ladderPosition, int number) {
        if (ladderPosition.equalToPositionX(number)){
            rows[number].printRowWithCurrentPosition(ladderPosition);
            return;
        }
        rows[number].printRowWithoutCurrentPosition();
    }

}
