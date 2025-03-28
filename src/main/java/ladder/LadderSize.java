package ladder;

public class LadderSize {

    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int getLineCount(){
        return (int)(this.numberOfRow.getNumber() * this.numberOfPerson.getNumber() * 0.3);
    }

    public int getRowSize() {
        return numberOfRow.getNumber();
    }

    public GreaterThanOne getColumnSize() {
        return numberOfPerson;
    }
}
