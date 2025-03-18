import exception.ExceptionMessage;

public class ValidationPosition {
    private final int[][] rows;

    private ValidationPosition(int rows[][]){
        this.rows = rows;
    }
    public static ValidationPosition of(int rows[][], int currentPosition){
        checkValidPostion(rows,currentPosition);
        return new ValidationPosition(rows);
    }
    private static void checkValidPostion(int rows[][], int currentPosition){
        if(currentPosition > rows[0].length){
            throw new IndexOutOfBoundsException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }
    }
}
