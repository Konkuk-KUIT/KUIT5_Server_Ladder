package ladder;

public class LadderSize {
    GreaterThanOne height;
    GreaterThanOne numberOfPerson;

    private LadderSize(GreaterThanOne height, GreaterThanOne numberOfPerson) {
        this.height = height;
        this.numberOfPerson = numberOfPerson;
    }

    public GreaterThanOne getHeight() {
        return height;
    }

    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }


    public int getHeightValue() {
        return height.getNumber();
    }

    public int getNumberOfPersonValue() {
        return numberOfPerson.getNumber();
    }

    static LadderSize of(GreaterThanOne height, GreaterThanOne numberOfPerson) {
        return new LadderSize(height, numberOfPerson);
    }
}
