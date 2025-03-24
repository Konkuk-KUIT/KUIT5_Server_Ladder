package ladder;

import ladder.creator.LadderCreator;

public class LadderSize {
    private final int numberOfRow;
    private final int numberOfPerson;

    public LadderSize(int numberOfRow, int numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public static LadderSize fromLadder(Row[] rows) {
        int numRows = rows.length;
        int numPersons = rows[0].getNumberOfPerson();
        return new LadderSize(numRows, numPersons);
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public int calculateAutoLineCount() {
        return (int) (numberOfRow * numberOfPerson * 0.3);
    }
}
