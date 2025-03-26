import exception.ExceptionMessage;

// 게임을 시작할 때 사다리 범위 내를 시작점으로 하는 지 검증하는 클래스
public class ValidationPosition {

    private ValidationPosition(int[][] rows){
    }
    public static ValidationPosition of(int[][] rows, int currentPosition){
        checkValidPostion(rows,currentPosition);
        return new ValidationPosition(rows);
    }
    private static void checkValidPostion(int[][] rows, int currentPosition){
        if(currentPosition > rows[0].length){
            throw new IndexOutOfBoundsException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }
    }
}
