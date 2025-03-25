// 사다리를 만드는
public class Ladder {
    private final LadderRows rows; // 사다리 배열

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        // 배열의 자연수만 쓰기 위해 NaturalNumber 클래스 활용
        // 사다리의 높이. 가로의 크기
        // 사다리 세로선 개수
        // 사다리 배열을 입력값과 동일하게 하려고 +1을 하여 생성
        this.rows = new LadderRows(row.getNaturalNumber() + 1, numberOfPerson.getNaturalNumber() + 1);
    }
    public void tryToDrawLine(NaturalNumber row,NaturalNumber column){
        ValidationDraw.validateDraw(rows, row.getNaturalNumber(), column.getNaturalNumber());
        rows.drawLine(row.getNaturalNumber(), column.getNaturalNumber());
    }
    public LadderRows getLadderRows() {
        return rows;
    }

}
