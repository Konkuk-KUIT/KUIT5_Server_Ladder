public enum Time {
    BEFORE("Before"),
    AFTER("After");

    private final String label;

    Time(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
