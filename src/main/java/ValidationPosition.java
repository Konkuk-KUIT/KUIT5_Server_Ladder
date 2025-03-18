import exception.ExceptionMessage;

public class ValidationPosition {
    private final int[][] rows;

    public ValidationPosition(int rows[][]){
        this.rows = rows;
    }
    public void checkValidPostion(int currentPosition){
        if(currentPosition > rows[0].length){
            throw new IndexOutOfBoundsException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }
    }
}
