public enum ExceptionMessage {
    ONLYNUMBER("자연수만 입력 가능합니다.");

    private final String message;



    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
