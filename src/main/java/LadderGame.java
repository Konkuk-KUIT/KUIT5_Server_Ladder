public class LadderGame {
    private final Ladder ladder;

    public LadderGame(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.ladder = new Ladder(numberOfRow.getValue(), numberOfPerson.getValue());
    }

    // 특정 위치(row, col)에 가로 선 그리기
    public void drawLine(int row, int col){
        ladder.drawLine(row-1, col-1);
    }

    // 선택한 위치에서 아래로 내려가며 최종 도착 위치 반환
    public int run(int selectedLadder){
        int row = 0;
        int col = selectedLadder-1;
        while(row < ladder.getNumberOfRow()){
            col = nextPosition(col, ladder.getDirection(row, col));
            row++;
        }
        return col+1;
    }

    // 현재 위치(col)에서 주어진 방향에 따라 다음 위치 계산
    public int nextPosition(int col, Direction direction){
        return col + direction.getValue();
    }
}
