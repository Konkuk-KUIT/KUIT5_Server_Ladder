public class LadderSize {
    private final int numberOfRow;
    private final int numberOfPerson;

    public LadderSize(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getLineCount() {
        return (int) (numberOfRow * numberOfPerson * 0.3);
    }
}
