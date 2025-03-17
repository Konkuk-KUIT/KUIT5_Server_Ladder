public class ValidationPosition {
    private final int[][] rows;

    public ValidationPosition(int rows[][]){
        this.rows = rows;
    }

    public void checkValidPostion(int currentPosition){
        if(currentPosition > rows[0].length){
            throw new IndexOutOfBoundsException("존재하지 않는 사다리 시작점입니다.");
        }
    }
}
