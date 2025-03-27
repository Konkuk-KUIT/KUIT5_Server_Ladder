public enum ExceptionMsg {
        INVALID_LINE_POSITION("마지막 열에는 선을 그을 수 없습니다."),
        ALREADY_CONNECTED("연속된 선이거나 이미 선이 그어져 있습니다."),
        MORE_THAN_ZERO("1이상의 값이여야 합니다."),
        INPUT_CANNOT_DOUBLE_TYPE("정수만 입력 가능합니다."),
        INVALID_LADDER_POSITION("잘못된 사다리 위치입니다.");


        private final String msg;

        ExceptionMsg(String msg) {
                this.msg = msg;
        }

        public String getMessage() {
                return msg;
        }
}
