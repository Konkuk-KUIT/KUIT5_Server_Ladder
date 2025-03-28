package ladder;

public enum LadderStar {
    STAR("* "), BLANK(" ");

    String now;
    LadderStar(String now) {
        this.now = now;
    }
    public String getValue() {return now;}
}
