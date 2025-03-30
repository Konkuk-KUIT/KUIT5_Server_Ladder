public class TestableLadder extends Ladder {
    private int lineCount = 0;

    public TestableLadder(int numberOfRow, int numberOfPerson) {
        super(numberOfRow, numberOfPerson);
    }

    @Override
    public void drawLine(int row, int col){
        super.drawLine(row, col);   // 원래 기능 그대로 유지하면서
        lineCount++;    // 추가로 라인 수 카운트
    }

    public int getLineCount() {
        return lineCount;
    }
}
