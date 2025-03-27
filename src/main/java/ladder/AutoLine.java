package ladder;

public enum AutoLine {
    LINE(10), RATIO(0.3);

    private final double value;

    AutoLine(int value) {
        this.value = value;
    }
    AutoLine(double value){this.value=value;}

    public double getValue() {
        return value;
    }
    public int getIntValue(){return (int)value;}
}
