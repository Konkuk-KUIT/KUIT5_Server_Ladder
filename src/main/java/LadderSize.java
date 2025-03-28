public class LadderSize {
    private final int numberOfRows;
    private final int numberOfPersons;

    public LadderSize(int numberOfRows, int numberOfPersons) {
        this.numberOfRows = numberOfRows;
        this.numberOfPersons = numberOfPersons;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public int calculateNumberOfLines() {
        return (int) (numberOfRows * numberOfPersons * 0.3);
    }
}