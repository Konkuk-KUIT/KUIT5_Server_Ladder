public enum ErrorMessage {
    INVALID_COLUMN("Column 값이 범위를 벗어났습니다."),
    INVALID_ROW("Row 값이 범위를 벗어났습니다."),
    LINE_ALREADY_EXISTS("라인이 이미 존재합니다."),
    NOT_POSITIVE("1 이상의 자연수여야 합니다."),

    // ErrorMessage.java
    MIN_ROW_TOO_SMALL("Row 수는 최소 1 이상이어야 합니다."),
    MIN_PERSON_TOO_FEW("참여자는 최소 2명 이상이어야 합니다."),

    NULL_LADDER("Ladder가 null입니다."),
    NULL_ROW("Row가 null입니다."),
    PRINT_ERROR("사다리 출력 중 오류가 발생했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
