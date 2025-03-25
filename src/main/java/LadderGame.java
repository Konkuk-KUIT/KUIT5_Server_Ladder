public class LadderGame {
    private final Ladder ladder;

    public LadderGame(int numberOfRow, int numberOfPerson) {
        this(new NaturalNumber(numberOfRow), new NaturalNumber(numberOfPerson));
    }

    public LadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.ladder = new Ladder(numberOfRow.getValue(), numberOfPerson.getValue());
    }

    // 특정 위치(row, col)에 가로 선 그리기
    public void drawLine(int row, int col) {
        ladder.drawLine(row-1, col-1);
    }

    // 선택한 위치에서 아래로 내려가며 최종 도착 위치 반환
    public int runWithTrace(int start) {
        LadderPosition position = new LadderPosition(0, start-1);

        while (position.getX() < ladder.getNumberOfRow()) {
            System.out.println("Before");
            ladder.print(position);

            Direction dir = ladder.getDirection(position.getX(), position.getY());
            position.moveHorizontally(dir);

            System.out.println("After");
            ladder.print(position);

            position.moveDown();
        }

        return position.getY() + 1;
    }
}
