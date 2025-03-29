class LadderRunner {
    private final int[][] ladder;
    private final NaturalNumber height;
    private final NaturalNumber people;

    public LadderRunner(int[][] ladder, NaturalNumber height, NaturalNumber people) {
        this.ladder = ladder;
        this.height = height;
        this.people = people;
    }

    public int run(int start) {
        int position = start;
        for (int i = 0; i < height.getValue(); i++) {
            if (position < people.getValue() - 1 && ladder[i][position] == 1) {
                position++;
                continue;
            }
            if (position > 0 && ladder[i][position - 1] == 1) {
                position--;
            }
        }
        return position;
    }
}