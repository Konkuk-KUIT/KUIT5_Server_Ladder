package ladderGame;

public class Column {
    private PositiveNumber number;
    private PositiveNumber person;

    public Column(int row, int person) {
        this.number = new PositiveNumber(row);
        this.person = new PositiveNumber(person);
        validate(row, person);
    }

    private void validate(int row, int person) {
        if (row > person)
            throw new IllegalArgumentException(ExceptionCode.COLUMN_OUT_OF_RANGE.getMessage());
    }

    public int getNumber() { return number.getNumber(); }

    public int getPerson() { return person.getNumber(); }
}