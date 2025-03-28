public class LadderSize {
    private final int numberOfRow;
    private final int numberOfPerson;

    private LadderSize(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize from(int numberOfRow, int numberOfPerson) {
        return new LadderSize(numberOfRow, numberOfPerson);
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }
}
