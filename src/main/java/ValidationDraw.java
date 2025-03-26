// 선을 그릴 수 있는 위치가 맞는지 검증하는 클래스
import exception.ExceptionMessage;

public class ValidationDraw {
    private ValidationDraw(){
        // 인스턴스화 방지
    }
    public static void validateDraw(LadderRows rows, int drawRow, int drawColumn){
        checkValidRange(rows,drawRow,drawColumn);
        checkDuplicatedLine(rows,drawRow,drawColumn);
    }

    // 존재하지 않는 배열 부분에 그리기 방지. 마지막 열에도 그릴 수 없음.
    private static void checkValidRange(LadderRows rows,int drawRow, int drawColumn) {
        if (drawRow >= rows.getHeight() || drawColumn >= rows.getWidth()-1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_POSITION.getMessage());
        }
    }
    // 이미 선이 있는 경우 방지
    private static void checkDuplicatedLine(LadderRows rows,int drawRow, int drawColumn) {
        if (rows.getRowsValue(drawRow,drawColumn)== 1 || rows.getRowsValue(drawRow,drawColumn)==-1) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATED_POSITION.getMessage());
        }
    }

}
