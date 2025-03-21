public class Ladder {

    private final LadderLines ladderLines;

    //사람 수와 사다리 높이를 받아 LadderLines 생성
    public Ladder(int numberOfPerson, int height) {
        ladderLines = new LadderLines(numberOfPerson, height);
    }

    //LadderLine의 drqwLine으로 위치에 가로줄 추가
    public void drawLine(int column, int row) {
        ladderLines.drawLine(column, row);
    }

    // 사다리 실행, 입력->최종 도착지 반환
    public int run(int startColumn) {
        return ladderLines.run(startColumn);
    }

    /**메인으로 과정 확인용 메소드
    public int getRowValueAt(int column, int row) {
        return ladderLines.getRowValueAt(column, row);
    } */
}
