public class Ladder {

    private Row[] rows;

    public Ladder(int rowSize, int numberOfPeople){
        this.rows = new Row[rowSize];
        for (int i = 0; i < rowSize; i++) {
            this.rows[i] = new Row(numberOfPeople);
        }
    }

    public void drawLine(Position row, Position col){
        rows[row.getValue()].drawLineOnNode(col);
    }

    //test코드 용 state 반환 메서드
    public int getState(Position row, Position col) {
        return rows[row.getValue()].getState(col);
    }

    //todo 사다리 크기에 대한 parsor

}
// 일단 LadderCreator, LadderRunner, enum, 정적팩토리 메서드 이런거 다 무시하고 생각해보면
// 사다리 타기게임에서 필요한 도메인이 뭔지 생각해보면
// 먼저 높이(Row) 객체, 그 높이 안에 있는 각 사다리줄 객체
// 이 두개로 drawLine먼저 구현을 해보면 좋을 것 같아
// drawLine구현하고 그 다음에 사다리 내려가는거 구현하고
// Row, Node, Position 이 정도로만 객체 나누고서 구현 도전해봐
