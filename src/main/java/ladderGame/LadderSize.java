package ladderGame;

public class LadderSize {
    private PositiveNumber height;
    private PositiveNumber person;

    public LadderSize(int height, int person) {
        this.height = new PositiveNumber(height);
        this.person = new PositiveNumber(person);
    }

    public int getRow() {
        return height.getNumber();
    }

    public int getColumn() {
        return person.getNumber();
    }

}
