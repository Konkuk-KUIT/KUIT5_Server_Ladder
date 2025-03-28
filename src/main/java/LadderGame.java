public class LadderGame {
    private final Ladder ladder;

    // 생성자
    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    // 새로운 생성자
    public LadderGame(LadderSize ladderSize,LadderCreator ladderCreator) {
        this.ladder = new Ladder(ladderSize.getNumberOfRow(), ladderSize.getNumberOfPerson());
        ladderCreator.createLines(ladder);
    }

    // 특정 위치(row, col)에 가로 선 그리기
    public void drawLine(int row, int col) {
        ladder.drawLine(row-1, col-1);
    }

    // 선택한 위치에서 아래로 내려가며 최종 도착 위치 반환
    public int run(int start) {
        LadderPosition position = new LadderPosition(0, start-1);
        LadderPrinter.printLadder(ladder, position);
        return position.getY() + 1;
    }
}
