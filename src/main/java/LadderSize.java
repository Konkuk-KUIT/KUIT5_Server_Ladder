public class LadderSize {
    private final NaturalNumber numberOfRow;
    private final NaturalNumber numberOfPerson;

    public LadderSize(NaturalNumber numberOfRow, NaturalNumber numberOfPerson) {
        this.numberOfRow = numberOfRow;
        this.numberOfPerson = numberOfPerson;
    }

    public int LadderMaxSize(){
        return (int) (0.3 * getRowCount() * (getPersonCount()-1));
    }

    public NaturalNumber getNumberOfRow() {
        return numberOfRow;
    }

    public NaturalNumber getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getRowCount(){
        return numberOfRow.getNum();
    }

    public int getPersonCount(){
        return numberOfPerson.getNum();
    }
}
