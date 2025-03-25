package ladder;

public class LadderSize {
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

//    public static LadderSize fromLadder(Row[] rows) {
//        int numRows = rows.length;
//        int numPersons = rows[0].getNumberOfPerson();
//        return new LadderSize(numRows, numPersons);
//    }

    public static LadderSize of(int row, int numberOfPerson) {
        return new LadderSize(GreaterThanOne.from(row), GreaterThanOne.from(numberOfPerson));
    }

    public int getNumberOfRow() {
        return numberOfRow.getNumber();
    }

    public int getNumberOfPerson() {
        return numberOfPerson.getNumber();
    }

    public int calculateAutoLineCount() {
        return (int) (getNumberOfRow() * getNumberOfPerson() * 0.3);
    }
}
