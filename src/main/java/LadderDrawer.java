class LadderDrawer {
    private final int[][] ladder;
    private final NaturalNumber height;
    private final NaturalNumber people;

    public LadderDrawer(int[][] ladder, NaturalNumber height, NaturalNumber people) {
        this.ladder = ladder;
        this.height = height;
        this.people = people;
    }

    public void draw(NonNegativeNumber row, NonNegativeNumber col) {
        int r = row.getValue();
        int c = col.getValue();

        if (r >= height.getValue() || c >= people.getValue() - 1) {
            throw new IllegalArgumentException(LadderError.INVALID_POSITION.getMessage());
        }

        if ((c > 0 && ladder[r][c - 1] == 1) || (c < people.getValue() - 2 && ladder[r][c + 1] == 1)) {
            throw new IllegalArgumentException(LadderError.CONTINUOUS_LINE.getMessage());
        }

        ladder[r][c] = 1;
        ladder[r][c + 1] = 1;
    }
}
