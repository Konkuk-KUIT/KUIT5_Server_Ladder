package ladderGame;

public enum ExceptionCode {

    // 생성 오류
    NOT_POSITIVE_INPUT("자연수만 허용됩니다."),
    ROW_OUT_OF_RANGE("세로는 사람 수보다 작아야 합니다."),
    COLUMN_OUT_OF_RANGE("가로는 사다리의 높이보다 작아야 합니다."),
    START_OUT_OF_RANGE("시작 지점은 사람 수보다 작아야 합니다."),
    NO_MORE_MOVES("더 이상 이동할 수 없습니다."),

    // 논리 오류
    PRESENT_LINE("이미 해당 위치에 선이 존재합니다."),
    ADJACENT_LINE("인접한 선이 존재합니다."),
    NO_SOLO_RANDOM_LADDER("플레이어 수가 부족합니다.");


    private String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

