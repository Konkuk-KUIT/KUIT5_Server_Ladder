public enum ErrorMessage {
    INVALID_COLUMN("Column 값이 범위를 벗어났습니다."),
    INVALID_ROW("Row 값이 범위를 벗어났습니다."),
    LINE_ALREADY_EXISTS("라인이 이미 존재합니다."),
    NOT_POSITIVE("1 이상의 자연수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
