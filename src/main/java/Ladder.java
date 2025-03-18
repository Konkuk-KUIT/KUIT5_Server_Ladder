public class Ladder {

    private final int[][] rows; // 사다리 배열
    private final int row; // 사다리의 높이. 가로의 크기
    private final int numberOfPerson; // 사다리 세로선 개수

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        // 배열의 자연수만 쓰기 위해 NaturalNumber 클래스 활용
        this.row=row.getNaturalNumber()+1;
        this.numberOfPerson=numberOfPerson.getNaturalNumber()+1;
        // 사다리 배열을 입력값과 동일하게 하려고 +1을 하여 생성
        rows = new int[this.row][this.numberOfPerson];
    }
    public void drawLine(NaturalNumber row,NaturalNumber column){
        int drawRow=row.getNaturalNumber();
        int drawColumn=column.getNaturalNumber();
        LadderGame.of(rows,drawRow,drawColumn);
    }
    public int run(NaturalNumber startPosition){
        int position = startPosition.getNaturalNumber();
        ValidationPosition.of(rows,position);
        for (int i = 1; i < rows.length; i++) {
            position+=rows[i][position];
        }
        return position;
    }

}
