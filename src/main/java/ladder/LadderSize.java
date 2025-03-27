package ladder;

public class LadderSize {
    private final GreaterThanOne numberOfRow;
    private final GreaterThanOne numberOfPerson;

    public LadderSize(GreaterThanOne numberOfRow, GreaterThanOne numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public GreaterThanOne getNumberOfRow() {
        return numberOfRow;
    }
    public GreaterThanOne getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getMultipledSize(){
        return numberOfRow.getNumber() * numberOfPerson.getNumber();
    }
}
