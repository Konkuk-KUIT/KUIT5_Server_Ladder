class LadderCreator {
    private final NaturalNumber height;
    private final NaturalNumber people;

    public LadderCreator(NaturalNumber height, NaturalNumber people) {
        this.height = height;
        this.people = people;
    }

    public int[][] create() {
        return new int[height.getValue()][people.getValue()];
    }
}