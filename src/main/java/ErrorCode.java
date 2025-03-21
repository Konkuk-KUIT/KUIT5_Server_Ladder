public enum ErrorCode {

    // Draw Errors
    OUT_OF_BOUNDS_ROW_POSITION("라인을 생성할 수 있는 행(row)의 범위를 초과한 위치입니다."),
    OUT_OF_BOUNDS_COL_POSITION("라인을 생성할 수 있는 열(column)의 범위를 초과한 위치입니다."),
    LINE_ALREADY_EXISTS("해당 위치에 이미 라인이 존재합니다."),
    INVALID_NUMBER_OF_POSITION("위치 입력값은 1 이상의 자연수여야 합니다.");

    private final String errorMessage;
    ErrorCode(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
