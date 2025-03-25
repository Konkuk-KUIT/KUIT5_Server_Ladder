package ladder;

public enum Time {

    BEFORE("Before"),
    AFTER("After");

    private final String time;

    Time(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}