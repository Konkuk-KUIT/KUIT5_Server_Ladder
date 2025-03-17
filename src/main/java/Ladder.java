public class Ladder {

    private final int[][] rows; // 사다리 배열
    private final int row; // 사다리의 높이. 가로의 크기
    private final int numberOfPerson; // 사다리 세로선 개수
    private final DrawPossible drawPossible; // 사다리를 그릴 수 있는 검증 후 통과하면 그리는 클래스
    private final ValidationPosition validationPosition;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        // 배열의 자연수만 쓰기 위해 NaturalNumber 클래스 활용
        this.row=row.getNaturalNumber()+1;
        this.numberOfPerson=numberOfPerson.getNaturalNumber()+1;
        // 사다리 배열을 입력값과 동일하게 하려고 +1을 하여 생성
        rows = new int[this.row][this.numberOfPerson];

        this.drawPossible = new DrawPossible(rows,this.row,this.numberOfPerson);
        this.validationPosition = new ValidationPosition(rows);
    }
    public void drawLine(NaturalNumber row,NaturalNumber column){
        int drawRow=row.getNaturalNumber();
        int drawColumn=column.getNaturalNumber();
        drawPossible.possilbe(drawRow,drawColumn);
    }
    public int run(NaturalNumber startPosition){
        int position = startPosition.getNaturalNumber();
        validationPosition.checkValidPostion(position);
        for (int i = 0; i < rows.length; i++) {
            if (position > 0 && rows[i][position - 1] == 1) {
                position--;
            } else if (position < numberOfPerson - 1 && rows[i][position] == 1) {
                position++;
            }
        }
        return position;
    }
//    public void movePosition(int currentRow, int currentPosition){
//        if(currentPosition){
//
//        }
//    }

}
