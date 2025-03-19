package exception;

public enum ExceptionMessage {
    /**
     * enum 열거 타입으로 예외 메시지 설정 한다.
     * enum 클래스로 쉽게 관리 가능 하다.
     */
    INVALID_DUPLICATED_POSITION("이미 라인이 그려진 위치입니다."),
    INVALID_DRAW_POSITION("라인 생성이 불가능한 위치입니다."),
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_NUMBER("자연수가 아닙니다."),
    INVALID_START_POSITION("시작점이 존재하지 않습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
